package io.annot8.impl.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.components.Resource;
import io.annot8.core.context.Context;

public class SimpleContext implements Context {
    private Map<Class<? extends Resource>, Map<String, Resource>> resources = new HashMap<>();
    private Map<String, Object> configuration = new HashMap<>();

    public void addConfiguration(String key, Object value){
        configuration.put(key, value);
    }

    public void addResource(String key, Resource resource){
        Map<String, Resource> classResources = resources.getOrDefault(resource.getClass(), new HashMap<>());
        classResources.put(key, resource);
        resources.put(resource.getClass(), classResources);
    }

    @Override
    public Optional<Object> getConfiguration(String key) {
        return Optional.ofNullable(configuration.get(key));
    }

    @Override
    public <T extends Resource> Optional<T> getResource(String key, Class<T> clazz) {
        Map<String, Resource> classResources = resources.getOrDefault(clazz, Collections.emptyMap());
        return Optional.ofNullable(clazz.cast(classResources.get(key)));
    }

    @Override
    public <T extends Resource> Stream<T> getResources(Class<T> clazz) {
        List<T> ret = new ArrayList<>();

        for(Resource r : resources.get(clazz).values())
            ret.add(clazz.cast(r));

        return ret.stream();
    }
}

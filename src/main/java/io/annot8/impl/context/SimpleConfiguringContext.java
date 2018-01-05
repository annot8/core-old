package io.annot8.impl.context;

import io.annot8.core.components.Resource;
import io.annot8.core.context.ConfiguringContext;
import io.annot8.core.context.Context;

import java.util.*;
import java.util.stream.Stream;

public class SimpleConfiguringContext implements ConfiguringContext {
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

        Resource r = classResources.get(key);
        if(r == null)
            return Optional.empty();

        return Optional.of((T) r);
    }

    @Override
    public <T extends Resource> Stream<T> getResources(Class<T> clazz) {
        List<T> ret = new ArrayList<>();

        for(Resource r : resources.get(clazz).values())
            ret.add((T) r);

        return ret.stream();
    }

    public static SimpleConfiguringContext fromContext(Context context){
        SimpleConfiguringContext spc = new SimpleConfiguringContext();

        //TODO: Copy configuration and resources from context
        
        return spc;
    }
}

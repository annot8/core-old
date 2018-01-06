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
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.stores.AnnotationStore;

public class SimpleProcessingContext implements ProcessingContext {
    private Map<Class<? extends Resource>, Map<String, Resource>> resources = new HashMap<>();
    private Map<String, Object> configuration = new HashMap<>();
    private AnnotationStore annotationStore;

    public SimpleProcessingContext(AnnotationStore annotationStore){
        this.annotationStore = annotationStore;
    }

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

    public static SimpleProcessingContext fromContext(AnnotationStore annotationStore, Context context){
        SimpleProcessingContext spc = new SimpleProcessingContext(annotationStore);

        //TODO: Copy configuration and resources from context

        return spc;
    }

    @Override
    public AnnotationStore getAnnotationStore() {
        return annotationStore;
    }

    @Override
    public void setAnnotationStore(AnnotationStore store) {
        this.annotationStore = store;
    }
}

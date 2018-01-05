package io.annot8.impl.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.stores.AnnotationStore;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InMemoryStore implements AnnotationStore {
    private Map<String, Annotation> annotations = new HashMap<>();

    @Override
    public void save(Annotation annotation) {
        annotations.put(annotation.getId(), annotation);

        //TODO: This should be logged properly
        System.out.println("Annotation of type "+annotation.getType()+" saved to store");
    }

    @Override
    public void delete(Annotation annotation) {
        annotations.remove(annotation.getId());

        //TODO: This should be logged properly
        System.out.println("Annotation with ID "+annotation.getId()+" removed from store");
    }

    @Override
    public Stream<Annotation> getAll() {
        return annotations.values().stream();
    }
}

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
    }

    @Override
    public void delete(Annotation annotation) {
        annotations.remove(annotation.getId());
    }

    @Override
    public Stream<Annotation> getAll() {
        return annotations.values().stream();
    }
}

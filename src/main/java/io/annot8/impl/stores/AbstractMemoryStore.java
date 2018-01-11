package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.AnnotationStore;

public abstract class AbstractMemoryStore<B extends Bounds> implements AnnotationStore<B> {
  private final Map<String, Annotation<B>> annotations = new HashMap<>();

  @Override
  public void save(final Annotation<B> annotation) {
    annotations.put(annotation.getId(), annotation);
  }

  @Override
  public void delete(final Annotation<B> annotation) {
    annotations.remove(annotation.getId());
  }

  @Override
  public Stream<Annotation<B>> getAll() {
    return annotations.values().stream();
  }


}

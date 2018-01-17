package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.data.Annotations;

public abstract class AbstractMemoryStore<B extends Bounds, A extends Annotation<B>>
    implements Annotations<B, A> {
  private final Map<String, A> annotations = new HashMap<>();

  private final String contentName;

  public AbstractMemoryStore(final String contentName) {
    this.contentName = contentName;
  }

  @Override
  public void save(final A annotation) {
    annotations.put(annotation.getId(), annotation);
  }

  @Override
  public void delete(final A annotation) {
    annotations.remove(annotation.getId());
  }

  @Override
  public Stream<A> getAll() {
    return annotations.values().stream();
  }

  @Override
  public Optional<A> getById(final String annotationId) {
    return Optional.ofNullable(annotations.get(annotationId));
  }

  public String getContentName() {
    return contentName;
  }
}

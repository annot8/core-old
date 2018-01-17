package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.EditableAnnotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.Annotations;

public abstract class AbstractMemoryStore<B extends Bounds, A extends Annotation<B>, E extends EditableAnnotation<B>>
    implements Annotations<B, A, E> {
  private final Map<String, A> annotations = new HashMap<>();

  private final String contentName;

  public AbstractMemoryStore(final String contentName) {
    this.contentName = contentName;
  }

  @Override
  public A save(final E annotation) {
    final A a = fromEditable(annotation);
    annotations.put(a.getId(), a);
    return a;
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

  protected abstract A fromEditable(E annotation);

}

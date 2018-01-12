package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.data.Annotations;

public abstract class AbstractMemoryStore<B extends Bounds, A extends Annotation<B>>
    implements Annotations<B, A> {
  private final Map<String, A> annotations = new HashMap<>();

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


}

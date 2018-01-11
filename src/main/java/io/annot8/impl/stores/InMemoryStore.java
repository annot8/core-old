package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.content.Content;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.annotations.SimpleLinearMention;

public class InMemoryStore implements AnnotationStore {
  private final Map<String, Annotation<? extends Bounds>> annotations = new HashMap<>();

  @Override
  public void save(final Annotation<? extends Bounds> annotation) {
    annotations.put(annotation.getId(), annotation);
  }

  @Override
  public void delete(final Annotation<? extends Bounds> annotation) {
    annotations.remove(annotation.getId());
  }

  @Override
  public Stream<Annotation<? extends Bounds>> getAll() {
    return annotations.values().stream();
  }

  @Override
  public <T extends Bounds> Annotation<T> createNew(final Content<?> content, final T bounds) {
    if (bounds instanceof LinearBounds) {
      return (Annotation<T>) new SimpleLinearMention(content, (LinearBounds) bounds);
      // TODO: Can't
      // get the
      // generics to
      // work right
      // here
      // without a
      // warning
    } else {
      return null; // TODO: What do we do if a store doesn't support this kind of Bounds?
    }
  }
}

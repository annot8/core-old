package io.annot8.impl.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.impl.annotations.SimpleLinearMention;

public class TextAnnotationMemoryStore extends AbstractMemoryStore<LinearBounds> {

  @Override
  public Annotation<LinearBounds> createNew(final LinearBounds bounds) {
    return new SimpleLinearMention(bounds);
  }
}

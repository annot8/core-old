package io.annot8.impl.stores;

import io.annot8.core.annotations.TextAnnotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.impl.annotations.SimpleLinearMention;

public class TextAnnotationMemoryStore extends AbstractMemoryStore<LinearBounds, TextAnnotation> {

  @Override
  public TextAnnotation createNew(final LinearBounds bounds) {
    return new SimpleLinearMention(bounds);
  }
}

package io.annot8.impl.stores;

import io.annot8.content.text.TextBounds;
import io.annot8.content.text.TextAnnotation;
import io.annot8.impl.annotations.SimpleTextAnnotation;

public class TextAnnotationMemoryStore extends AbstractMemoryStore<TextBounds, TextAnnotation> {

  @Override
  public TextAnnotation createNew(final TextBounds bounds) {
    return new SimpleTextAnnotation(bounds);
  }
}

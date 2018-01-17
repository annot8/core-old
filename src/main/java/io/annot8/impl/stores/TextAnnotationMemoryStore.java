package io.annot8.impl.stores;

import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.impl.annotations.SimpleTextAnnotation;
import io.annot8.impl.bounds.SimpleTextBounds;

public class TextAnnotationMemoryStore extends AbstractMemoryStore<TextBounds, TextAnnotation>
    implements TextAnnotations {

  public TextAnnotationMemoryStore(final String contentName) {
    super(contentName);
  }

  @Override
  public TextAnnotation createNew(final TextBounds bounds) {
    return new SimpleTextAnnotation(getContentName(), bounds);
  }

  @Override
  public TextAnnotation create(final int begin, final int end) {
    return createNew(new SimpleTextBounds(begin, end));
  }



}

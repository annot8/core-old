package io.annot8.impl.stores;

import io.annot8.base.stores.AbstractMemoryStore;
import io.annot8.content.text.EditableTextAnnotation;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.impl.annotations.SimpleEditableTextAnnotation;
import io.annot8.impl.annotations.SimpleTextAnnotation;
import io.annot8.impl.bounds.SimpleTextBounds;

public class SimpleTextAnnotations
    extends AbstractMemoryStore<TextBounds, TextAnnotation, EditableTextAnnotation>
    implements TextAnnotations {

  public SimpleTextAnnotations(final String contentName) {
    super(contentName);
  }

  @Override
  public EditableTextAnnotation create(final TextBounds bounds) {
    return new SimpleEditableTextAnnotation(this, getContentName(), bounds);
  }

  @Override
  public EditableTextAnnotation create(final int begin, final int end) {
    return create(new SimpleTextBounds(begin, end));
  }

  @Override
  protected TextAnnotation fromEditable(final EditableTextAnnotation annotation) {
    return new SimpleTextAnnotation(this, annotation);
  }

}

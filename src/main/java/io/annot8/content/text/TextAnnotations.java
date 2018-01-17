package io.annot8.content.text;

import io.annot8.core.stores.Annotations;

public interface TextAnnotations
    extends Annotations<TextBounds, TextAnnotation, EditableTextAnnotation> {

  EditableTextAnnotation create(final int begin, final int end);

}

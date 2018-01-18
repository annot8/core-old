package io.annot8.content.text;

import io.annot8.core.annotations.EditableAnnotation;

public interface EditableTextAnnotation extends TextAnnotation, EditableAnnotation<TextBounds> {

  @Override
  TextAnnotation save();

  @Override
  default EditableTextAnnotation edit() {
    return this;
  }

}

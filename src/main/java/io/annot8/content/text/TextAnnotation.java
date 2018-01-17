package io.annot8.content.text;

import io.annot8.core.annotations.Annotation;

public interface TextAnnotation extends Annotation<TextBounds> {

  @Override
  EditableTextAnnotation edit();
}

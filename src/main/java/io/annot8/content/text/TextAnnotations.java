package io.annot8.content.text;

import io.annot8.core.stores.Annotations;

public interface TextAnnotations extends Annotations<TextBounds, TextAnnotation> {

  TextAnnotation create(final int begin, final int end);

}

package io.annot8.content.image;

import io.annot8.core.data.TypedContent;

public interface Image extends
    TypedContent<ImageBounds, ImageAnnotation, EditableImageAnnotation, ImageAnnotations, byte[]> {

  int getWidth();

  int getHeight();
}

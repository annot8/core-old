package io.annot8.content.image;

import io.annot8.core.content.TypedContent;

public interface Image
    extends TypedContent<ImageBounds, ImageAnnotation, ImageAnnotationStore, byte[]> {

  int getWidth();

  int getHeight();
}

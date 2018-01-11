package io.annot8.core.content;

import io.annot8.core.annotations.ImageAnnotation;
import io.annot8.core.bounds.AreaBounds;
import io.annot8.core.stores.ImageAnnotationStore;

public interface Image extends Content<AreaBounds, ImageAnnotation, ImageAnnotationStore, byte[]> {

  int getWidth();

  int getHeight();
}

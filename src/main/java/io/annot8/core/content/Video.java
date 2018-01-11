package io.annot8.core.content;

import io.annot8.core.annotations.VideoAnnotation;
import io.annot8.core.bounds.IndexedAreaBounds;
import io.annot8.core.stores.VideoAnnotationStore;

public interface Video
    extends TypedContent<IndexedAreaBounds, VideoAnnotation, VideoAnnotationStore, byte[]> {

  int getFrames();

  int getWidth();

  int getHeight();

  Image getImage(int frame);

}

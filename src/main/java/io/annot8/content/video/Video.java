package io.annot8.content.video;

import io.annot8.content.image.Image;
import io.annot8.core.content.TypedContent;

public interface Video
    extends TypedContent<VideoBounds, VideoAnnotation, VideoAnnotationStore, byte[]> {

  int getFrames();

  int getWidth();

  int getHeight();

  Image getImage(int frame);

}

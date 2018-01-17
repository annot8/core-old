package io.annot8.content.video;

import io.annot8.content.image.Image;
import io.annot8.core.data.TypedContent;

public interface Video extends
    TypedContent<VideoBounds, VideoAnnotation, EditableVideoAnnotation, VideoAnnotations, byte[]> {

  int getFrames();

  int getWidth();

  int getHeight();

  Image getImage(int frame);

}

package io.annot8.core.content;

public interface Video extends Content<byte[]> {

  int getFrames();

  int getWidth();

  int getHeight();

  Image getImage(int frame);

  default Class<byte[]> getContentClass() {
    return byte[].class;
  }

}

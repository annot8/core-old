package io.annot8.core.documents;

public interface Video extends Content<byte[]> {

  int getFrames();

  int getWidth();

  int getHeight();

  Image getImage(int frame);

}

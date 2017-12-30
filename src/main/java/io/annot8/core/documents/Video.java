package io.annot8.core.documents;

public interface Video extends Content<byte[]> {

  int getFrames();

  Image getImage(int frame);

}

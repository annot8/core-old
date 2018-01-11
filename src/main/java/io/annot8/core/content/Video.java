package io.annot8.core.content;

import io.annot8.core.bounds.IndexedAreaBounds;

public interface Video extends Content<IndexedAreaBounds, byte[]> {

  int getFrames();

  int getWidth();

  int getHeight();

  Image getImage(int frame);

}

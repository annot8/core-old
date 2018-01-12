package io.annot8.content.image;

import io.annot8.core.bounds.Bounds;

public interface ImageBounds extends Bounds {
  int getTop();

  void setTop(int top);

  int getBottom();

  void setBottom(int bottom);

  int getLeft();

  void setLeft(int left);

  int getRight();

  void setRight(int right);
}

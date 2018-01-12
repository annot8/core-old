package io.annot8.core.bounds;

public interface IndexedAreaBounds extends Bounds {

  // Area bounds

  int getTop();

  void setTop(int top);

  int getBottom();

  void setBottom(int bottom);

  int getLeft();

  void setLeft(int left);

  int getRight();

  void setRight(int right);

  // Start and end frame

  int getBegin();

  void setBegin(int begin);

  int getEnd();

  void setEnd(int end);
}

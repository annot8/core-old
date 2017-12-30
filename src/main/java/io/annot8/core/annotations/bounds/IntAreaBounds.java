package io.annot8.core.annotations.bounds;

public interface IntAreaBounds extends Bounds {

  int getTop();

  void setTop();

  int getBottom();

  void setBottom();

  int getLeft();

  void setLeft(int left);

  int getRight();

  void setRight(int right);

  default int getWidth() {
    return getRight() - getLeft();
  }

  default int getHeight() {
    return getTop() - getBottom();
  }
}

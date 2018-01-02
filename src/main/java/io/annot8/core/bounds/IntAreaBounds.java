package io.annot8.core.bounds;

public interface IntAreaBounds extends IntLineBounds {

  int getTop();

  void setTop(int top);

  int getBottom();

  void setBottom(int bottom);

  default int getHeight() {
    return getTop() - getBottom();
  }
}

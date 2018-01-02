package io.annot8.core.bounds;

public interface DoubleAreaBounds extends DoubleLineBounds {

  double getTop();

  void setTop(double top);

  double getBottom();

  void setBottom(double bottom);

  default double getHeight() {
    return getTop() - getBottom();
  }
}

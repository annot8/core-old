package io.annot8.core.bounds;

public interface DoubleLineBounds extends Bounds {

  /**
   * Return the begin offset
   */
  double getLeft();

  /**
   * Set the begin offset
   */
  void setLeft(double begin);

  /**
   * Return the end offset
   */
  double getRight();

  /**
   * Set the end offset
   */
  void setRight(double end);

  default double getWidth() {
    return getRight() - getLeft();
  }
}

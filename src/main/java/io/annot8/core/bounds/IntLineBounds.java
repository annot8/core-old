package io.annot8.core.bounds;

public interface IntLineBounds extends Bounds {

  /**
   * Return the begin offset
   */
  int getLeft();

  /**
   * Set the begin offset
   */
  void setLeft(int begin);

  /**
   * Return the end offset
   */
  int getRight();

  /**
   * Set the end offset
   */
  void setRight(int end);

  default int getWidth() {
    return getRight() - getLeft();
  }
}

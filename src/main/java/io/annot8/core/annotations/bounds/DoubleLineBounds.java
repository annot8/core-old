package io.annot8.core.annotations.bounds;

public interface DoubleLineBounds extends Bounds {

  /**
   * Return the begin offset
   */
  double getBegin();

  /**
   * Set the begin offset
   */
  void setBegin(double begin);

  /**
   * Return the end offset
   */
  double getEnd();

  /**
   * Set the end offset
   */
  void setEnd(double end);

  default double getLength() {
    return getEnd() - getBegin();
  }
}

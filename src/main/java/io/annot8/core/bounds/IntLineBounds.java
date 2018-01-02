package io.annot8.core.bounds;

public interface IntLineBounds extends Bounds {

  /**
   * Return the begin offset
   */
  int getBegin();

  /**
   * Set the begin offset
   */
  void setBegin(int begin);

  /**
   * Return the end offset
   */
  int getEnd();

  /**
   * Set the end offset
   */
  void setEnd(int end);

  default int getLength() {
    return getEnd() - getBegin();
  }
}

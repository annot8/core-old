package io.annot8.core.annotations.bounds;

public interface IntegerLineBound {

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
}

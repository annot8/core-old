package io.annot8.core.helpers;

public interface WithType {

  /**
   * Return the type, if it has been set
   */
  default String getType() {
    return this.getClass().getSimpleName();
  }
}

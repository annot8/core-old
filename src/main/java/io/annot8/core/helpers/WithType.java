package io.annot8.core.helpers;

import java.util.Optional;

public interface WithType {

  /**
   * Return the type, if it has been set
   */
  default String getType() {
    return this.getClass().getSimpleName();
  }
}

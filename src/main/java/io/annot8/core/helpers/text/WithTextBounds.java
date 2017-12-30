package io.annot8.core.helpers.text;

import io.annot8.core.annotations.bounds.IntLineBounds;
import io.annot8.core.helpers.WithBounds;

public interface WithTextBounds extends WithBounds<IntLineBounds> {

  default int getBegin() {
    return getBounds().getBegin();
  }

  default void setBegin(int begin) {
    getBounds().setBegin(begin);
  }

  default int getEnd() {
    return getBounds().getEnd();
  }

  default void setEnd(int begin) {
    getBounds().setEnd(begin);
  }
}

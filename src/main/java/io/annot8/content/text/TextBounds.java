package io.annot8.content.text;

import io.annot8.core.bounds.Bounds;

public interface TextBounds extends Bounds {

  int getBegin();

  void setBegin(int begin);

  int getEnd();

  void setEnd(int end);
}

package io.annot8.content.video;

import io.annot8.core.bounds.Bounds;

public interface VideoBounds extends Bounds {

  // Area bounds

  int getTop();

  void setTop(int top);

  int getBottom();

  void setBottom(int bottom);

  int getLeft();

  void setLeft(int left);

  int getRight();

  void setRight(int right);

  // Start and end frame

  int getBegin();

  void setBegin(int begin);

  int getEnd();

  void setEnd(int end);
}

package io.annot8.content.video;

import io.annot8.core.bounds.Bounds;

public interface VideoBounds extends Bounds {

  // TODO: this will be more sophisticated in practise, but the below provides bounding boxes for
  // change

  // Area bounds

  int getTop();

  int getBottom();

  int getLeft();

  int getRight();

  // Start and end frame

  int getBegin();

  int getEnd();
}

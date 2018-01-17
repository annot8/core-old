package io.annot8.content.audio;

import io.annot8.core.bounds.Bounds;

public interface AudioBounds extends Bounds {

  // TODO: is this sample index (doubke) or time indexed (seconds into)? Suggest both, hence better
  // naming of methods

  int getBegin();

  int getEnd();
}

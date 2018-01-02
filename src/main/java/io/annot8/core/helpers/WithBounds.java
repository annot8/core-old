package io.annot8.core.helpers;

import io.annot8.core.bounds.Bounds;

public interface WithBounds {

  Bounds getBounds();

  void setBounds(Bounds bound);
}

package io.annot8.core.helpers;

import io.annot8.core.bounds.Bounds;

public interface WithBounds<B extends Bounds> {

  B getBounds();

  void setBounds(B bound);
}

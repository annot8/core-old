package io.annot8.core.content;

import io.annot8.core.bounds.AreaBounds;

public interface Image extends Content<AreaBounds, byte[]> {

  int getWidth();

  int getHeight();
}

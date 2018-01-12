package io.annot8.content.other;

import io.annot8.core.bounds.Bounds;

// TODO: Dead? since we have a type safe content...
@Deprecated
public class NoBounds implements Bounds {

  /**
   * Singleton version
   */
  public static final NoBounds NO_BOUNDS = new NoBounds();

  private NoBounds() {
    // Singleton
  }
}

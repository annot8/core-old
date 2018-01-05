package io.annot8.core.bounds;

public class NoBounds implements Bounds {

  /**
   * Singleton version
   */
  public static final NoBounds NO_BOUNDS = new NoBounds();

  private NoBounds() {
    // Singleton
  }
}

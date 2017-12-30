package io.annot8.core.annotations.bounds;

public class NoBounds implements Bounds {

  /**
   * Singleon version
   */
  public static final NoBounds NO_BOUNDS = new NoBounds();

  private NoBounds() {
    // Singleton
  }

}

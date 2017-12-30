package io.annot8.core.annotations;

import io.annot8.core.annotations.bounds.Bounds;
import io.annot8.core.annotations.bounds.NoBounds;
import io.annot8.core.helpers.WithValue;

/**
 * Annotation to hold document level metadata that has no
 * location within the text. For example, a document author
 * or creation date.
 */
public interface Metadata extends Annotation, WithValue {

  /**
	 * Get the key for this annotation
	 */
  String getKey();
	
	/**
	 * Set the key for this annotation
	 */
  void setKey(String key);

  @Override
  default Bounds getBounds() {
    return NoBounds.NO_BOUNDS;
  }
}

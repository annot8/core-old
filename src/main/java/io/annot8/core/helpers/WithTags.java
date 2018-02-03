package io.annot8.core.helpers;

import io.annot8.core.data.Tags;

/**
 * Helper interface to indicate that a class supports Tags
 */
public interface WithTags {
  /**
   * Return the tags associated with this object
   */
  Tags getTags();
}

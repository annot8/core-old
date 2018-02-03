package io.annot8.core.helpers.builders;

import io.annot8.core.data.Tags;

/**
 * Helper interface to indicate that a builder should support adding
 * tags to an object
 * 
 * @param <A>
 * 		The builder class
 */
public interface WithTagsBuilder<A> {
  /**
   * Return a builder with the tag added to it
   */
  A withTag(final String tag);

  /**
   * Return a builder with the specified tags
   */
  A withTags(final Tags tags);
}

package io.annot8.core.helpers.builders;

/**
 * Helper interface to indicate that a builder should support setting
 * a type on an object
 * 
 * @param <A>
 * 		The builder class
 */
public interface WithTypeBuilder<A> {
  /**
   * Return a builder with the type set to the specified value
   */
  A withType(final String type);
}

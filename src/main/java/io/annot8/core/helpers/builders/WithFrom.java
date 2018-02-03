package io.annot8.core.helpers.builders;

/**
 * Helper interface to indicate that a builder can create an object
 * based off an existing object of the same type
 * 
 * @param <A>
 * 		The builder class
 * @param <B>
 * 		The object class from which an object should be based
 */
public interface WithFrom<A, B> {

  /**
   * Return a builder based on an existing object
   */
  A from(final B from);
}

package io.annot8.core.helpers;

import io.annot8.core.properties.ImmutableProperties;

/**
 * Indicates that an object stores a collection of properties (key-value pairs)
 *
 * Helper interface to reduce duplicate code.
 */
public interface WithProperties {

  ImmutableProperties getProperties();
}

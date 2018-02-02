package io.annot8.core.helpers;

import io.annot8.core.properties.MutableProperties;

/**
 * Helper interface to indicate that a class supports MutableProperties
 */
public interface WithMutableProperties {

	/**
	 * Return the mutable properties associated with this object
	 */
  MutableProperties getProperties();
}

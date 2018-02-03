package io.annot8.core.helpers.builders;

import io.annot8.core.properties.Properties;

/**
 * Helper interface to indicate that a builder should support adding
 * properties to an object
 * 
 * @param <A>
 * 		The builder class
 */
public interface WithPropertiesBuilder<A> {
	/**
	 * Return a builder with the key-value property pair added to it
	 */
    A withProperty(final String key, final Object value);
    
    /**
     * Return a builder with the specified properties
     */
    A withProperties(final Properties properties);
}

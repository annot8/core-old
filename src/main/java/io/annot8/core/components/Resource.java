package io.annot8.core.components;

import java.util.Map;

import io.annot8.core.exceptions.BadConfigurationException;

/**
 * A reusable resource (for example a database connection, or a preloaded
 * dataset) that can be used by other components.
 */
public interface Resource extends AutoCloseable {
	public void configure(Map<String, Object> configuration) throws BadConfigurationException;
	
	//TODO: Need a way of declaring resource configuration
}

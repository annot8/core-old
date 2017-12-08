package io.annot8.core.components;

import io.annot8.core.context.Context;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;

/**
 * A reusable resource (for example a database connection, or a preloaded
 * dataset) that can be used by other components.
 */
public interface Resource extends AutoCloseable {
	public void configure(Context context) throws BadConfigurationException, MissingResourceException;}

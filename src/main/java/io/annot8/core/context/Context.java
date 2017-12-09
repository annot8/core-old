package io.annot8.core.context;

import java.util.Optional;

import io.annot8.core.components.Resource;

/**
 * Context interface to hold configuration and resources to be passed to a component,
 * usually at creation time.
 */
public interface Context {
	Optional<Object> getConfiguration(String key);
	<T> Optional<T> getConfiguration(String key, Class<?> T);
	
	<T extends Resource> Optional<T> getResource(String key, Class<? extends Resource> T);
}

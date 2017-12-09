package io.annot8.core.context;

import java.util.Optional;

import io.annot8.core.components.Resource;
import java.util.stream.Stream;

/**
 * Context interface to hold configuration and resources to be passed to a component,
 * usually at creation time.
 */
public interface Context {
	Optional<Object> getConfiguration(String key);
	<T> Optional<T> getConfiguration(String key, Class<?> T);
	
	<T extends Resource> Optional<T> getResource(String key, Class<T> clazz);

	default <T extends Resource> Optional<T> getResource(Class<T> clazz) {
		return getResources(clazz).findFirst();
	}

	<T extends Resource> Stream<T> getResources(Class<T> clazz);

}

package io.annot8.core.helpers;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Indicates that an object stores a collection of properties (key-value pairs)
 *
 * Helper interface to reduce duplicate code.
 */
public interface WithProperties {

	/**
	 * Returns true if a property with the given exists
	 */
	default boolean hasProperty(String key) {
		return getProperties().containsKey(key);
	}

	default <T> boolean hasProperty(String key, Class<T> clazz) {
		return getProperties(clazz).containsKey(key);
	}

	/**
	 * Return the property value for the specified key, if it exists
	 */
	default Optional<Object> getProperty(String key) {
		return Optional.ofNullable(getProperties().get(key));
	}

	default <T> Optional<T> getProperty(String key, Class<T> clazz){
		return Optional.ofNullable(getProperties(clazz).get(key));
	}

	/**
	 * Return the property value for the specified key, or a default value if the key doesn't exist
	 */
	default Object getPropertyOrDefault(String key, Object defaultValue) {
		return getProperty(key).orElse(defaultValue);
	}

	default <T> T getPropertyOrDefault(String key, T defaultValue, Class<T> clazz) {
		return getProperty(key, clazz).orElse(defaultValue);
	}

	/**
	 * Set the property value for the specified key
	 */
	void setProperty(String key, Object value);

	/**
	 * Remove the property for the specified key, and return it's object (if it exists)
	 */
	Optional<Object> removeProperty(String key);

	/**
	 * List the currently set property keys
	 */
	default Stream<String> listPropertyKeys() {
		return getProperties().keySet().stream();
	}

	default <T> Stream<String> listPropertyKeys(Class<T> clazz) {
		return getProperties(clazz).keySet().stream();
	}

	/**
	 * Return a map of all properties
	 */
	Map<String, Object> getProperties();

	default <T> Map<String, T> getProperties(Class<T> clazz) {
		return getProperties().entrySet().stream()
			.filter(e -> clazz.isInstance(e.getValue()))
			.collect(Collectors.toMap(e -> e.getKey(), e -> clazz.cast(e.getValue())));
	}

	/**
	 * Set the current properties to be equal to the map
	 */
	default void setProperties(Map<String, Object> properties) {
		clear();
		addProperties(properties);
	}

	/**
	 * Return a map of all properties
	 */
	default void clear() {
		listPropertyKeys().forEach(this::removeProperty);
	}

	/**
	 * Add all properties from the given map, overwriting values where they already exist
	 */
	default void addProperties(Map<String, Object> properties) {
		properties.forEach(this::setProperty);
	}

	/**
	 * Remove all properties that match the given keys
	 */
	default void removeProperties(Collection<String> keys) {
		keys.forEach(this::removeProperty);
	}

}

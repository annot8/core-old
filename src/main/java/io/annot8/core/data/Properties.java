package io.annot8.core.data;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Indicates that an object stores a collection of properties (key-value pairs)
 *
 * Helper interface to reduce duplicate code.
 */
public interface Properties {

  // TODO: CF I belive this should have more clazz params so it does safe checking and casting for
  // us

  /**
   * Returns true if a property with the given exists
   */
  default boolean has(String key) {
    return getKeys().anyMatch(key::equals);
  }

  /**
   * Return the property value for the specified key, if it exists
   */
  default Optional<Object> get(String key) {
    return Optional.ofNullable(getAll().get(key));
  }

  /**
   * Return the property value for the specified key, or a default value if the key doesn't exist
   */
  default <T> T getOrDefault(String key, T defaultValue) {
    return (T) get(key).orElse(defaultValue);
  }

  /**
   * Set the property value for the specified key
   */
  void set(String key, Object value);

  /**
   * Remove the property for the specified key, and return it's object (if it exists)
   */
  Optional<Object> remove(String key);

  /**
   * List the currently set property keys
   */
  default Stream<String> getKeys() {
    return getAll().keySet().stream();
  }

  /**
   * Return a map of all properties
   */
  Map<String, Object> getAll();

  /**
   * Set the current properties to be equal to the map
   */
  default void set(Map<String, Object> properties) {
    clear();
    add(properties);
  }

  /**
   * Return a map of all properties
   */
  default void clear() {
    getKeys().forEach(this::remove);
  }

  /**
   * Add all properties from the given map, overwriting values where they already exist
   */
  default void add(Map<String, Object> properties) {
    properties.forEach(this::set);
  }

  /**
   * Remove all properties that match the given keys
   */
  default void remove(Collection<String> keys) {
    keys.forEach(this::remove);
  }

}

package io.annot8.core.helpers;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Indicates that an object stores a collection of properties (key-value pairs)
 *
 * Helper interface to reduce duplicate code.
 */
public interface WithProperties {

  // TODO: CF I belive this should have more clazz params so it does safe checking and casting for
  // us

  /**
   * Returns true if a property with the given exists
   */
  default boolean hasProperty(String key) {
    return listPropertyKeys().anyMatch(key::equals);
  }

  /**
   * Return the property value for the specified key, if it exists
   */
  default Optional<Object> getProperty(String key) {
    return Optional.ofNullable(getProperties().get(key));
  }

  /**
   * Return the property value for the specified key, or a default value if the key doesn't exist
   */
  default Object getPropertyOrDefault(String key, Object defaultValue) {
    return getProperty(key).orElse(defaultValue);
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

  /**
   * Return a map of all properties
   */
  Map<String, Object> getProperties();

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

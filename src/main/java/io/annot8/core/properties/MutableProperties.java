package io.annot8.core.properties;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Base mutable properties interface from which all other mutable properties extend.
 */
public interface MutableProperties extends Properties {

   /**
   * Set the property value for the specified key
   */
  void set(final String key, final Object value);

  /**
   * Remove the property for the specified key, and return it's object (if it exists)
   */
  Optional<Object> remove(final String key);


  /**
   * Set the current properties to be equal to the map
   */
  default void set(final Map<String, Object> properties) {
    removeAll();
    add(properties);
  }

  /**
   * Return a map of all properties
   */
  default void removeAll() {
    keys().forEach(this::remove);
  }

  /**
   * Add all properties from the given map, overwriting values where they already exist
   */
  default void add(final Map<String, Object> properties) {
    if (properties != null) {
      properties.forEach(this::set);
    }
  }

  /**
   * Remove all properties that match the given keys
   */
  default void remove(final Collection<String> keys) {
    if (keys != null) {
      keys.forEach(this::remove);
    }
  }

}

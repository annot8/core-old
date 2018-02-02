package io.annot8.core.properties;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Indicates that an object stores a collection of properties (key-value pairs)
 *
 * Helper interface to reduce duplicate code.
 */
public interface Properties {

  /**
   * Returns true if a property with the given exists
   */
  default boolean has(final String key) {
    return getAll().containsKey(key);
  }

  default boolean has(final String key, final Class<?> clazz) {
    return getAll(clazz).containsKey(key);
  }

  /**
   * Return the property value for the specified key, if it exists
   */
  default Optional<Object> get(final String key) {
    return Optional.ofNullable(getAll().get(key));
  }

  default <T> Optional<T> getProperty(final String key, final Class<T> clazz) {
    return Optional.ofNullable(getAll(clazz).get(key));
  }

  /**
   * Return the property value for the specified key, or a default value if the key doesn't exist
   */
  default Object getObjectOrDefault(final String key, final Object defaultValue) {
    return get(key).orElse(defaultValue);
  }

  @SuppressWarnings("unchecked")
  default <T> T getOrDefault(final String key, final T defaultValue) {
    final Class<? extends Object> clazz = defaultValue.getClass();
    final Object o = getObjectOrDefault(key, defaultValue.getClass());
    if (o != null && clazz.isInstance(o)) {
      return (T) clazz.cast(o);
    } else {
      return defaultValue;
    }
  }

  /**
   * List the currently set property keys
   */
  default Stream<String> keys() {
    return getAll().keySet().stream();
  }

  default <T> Stream<String> listKeys(final Class<T> clazz) {
    return getAll(clazz).keySet().stream();
  }

  /**
   * Return a map of all properties
   */
  Map<String, Object> getAll();

  default <T> Map<String, T> getAll(final Class<T> clazz) {
    return getAll().entrySet().stream().filter(e -> clazz.isInstance(e.getValue()))
        .collect(Collectors.toMap(Entry<String, Object>::getKey, e -> clazz.cast(e.getValue())));
  }
}

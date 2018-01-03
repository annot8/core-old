package io.annot8.core.context;

import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.components.Resource;

/**
 * Context interface to hold configuration and resources to be passed to a component, usually at
 * creation time.
 */
public interface Context {

  Optional<Object> getConfiguration(String key);

  @SuppressWarnings("unchecked")
  default <T> Optional<T> getConfiguration(String key, Class<?> clazz) {
    Optional<Object> o = getConfiguration(key);
    if (o.isPresent()) {
      Object v = o.get();
      if (clazz.isInstance(v)) {
        return Optional.of((T) v);
      }
    }
    return Optional.empty();
  }

  <T extends Resource> Optional<T> getResource(String key, Class<T> clazz);

  default <T extends Resource> Optional<T> getResource(Class<T> clazz) {
    return getResources(clazz).findFirst();
  }

  <T extends Resource> Stream<T> getResources(Class<T> clazz);

}

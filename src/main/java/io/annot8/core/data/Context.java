package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.components.Resource;

/**
 * Context interface to hold configuration and resources to be passed to a component, usually at
 * creation time.
 */
public interface Context {

  Item createItem();

  Optional<Object> getConfiguration();

  default <T> T getConfiguration(final Class<T> clazz) {
    final Optional<Object> o = getConfiguration();
    if (o.isPresent()) {
      final Object v = o.get();
      if (clazz.isInstance(v)) {
        return clazz.cast(v);
      }
    }

    // Attempt to create an instance of the class (assuming it will have default set)
    try {
      return clazz.getConstructor().newInstance();
    } catch (final Exception e) {
      return null;
    }
  }

  <T extends Resource> Optional<T> getResource(String key, Class<T> clazz);

  default <T extends Resource> Optional<T> getResource(final Class<T> clazz) {
    return getResources(clazz).findFirst();
  }

  <T extends Resource> Stream<T> getResources(Class<T> clazz);

  // TODO: JB - I think this needs to be better defined to match other classes. For instance, how do
  // you get a list of keys?

}

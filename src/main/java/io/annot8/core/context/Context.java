package io.annot8.core.context;

import io.annot8.core.components.Resource;
import io.annot8.core.settings.Settings;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Base context interface from which all context implementations extend.
 */
public interface Context {

	/**
	 * Return the settings object for the component that this context is being passed to.
	 */
  Optional<Settings> getSettings();

  /**
   * Return a settings object as the given class, attempting to create a new settings
   * object of that class if the currently given settings are not of this class.
   */
  default <T extends Settings> T getSettings(final Class<T> clazz) {
    final Optional<Settings> o = getSettings();
    if (o.isPresent()) {
      final Object v = o.get();
      if (clazz.isInstance(v)) {
        return clazz.cast(v);
      }
    }

    try {
      return clazz.getConstructor().newInstance();
    } catch (final Exception e) {
      return null;
    }
  }

  /**
   * Return the resource of the given type associated with the given key
   */
  <T extends Resource> Optional<T> getResource(String key, Class<T> clazz);

  /**
   * List all the resource keys contained within this context
   */
  Stream<String> getResourceKeys();
  
  /**
   * List all the resource keys contained within this context that are of the specified type
   */
  default Stream<String> getResourceKeys(Class<? extends Resource> clazz){
    return getResourceKeys().filter(s -> getResource(s, clazz).isPresent());
  }

  /**
   * Return any resource (if there is one) of the specified type
   */
  default <T extends Resource> Optional<T> getResource(final Class<T> clazz) {
    return getResources(clazz).findFirst();
  }

  /**
   * Return all resources of the specified type
   */
  <T extends Resource> Stream<T> getResources(Class<T> clazz);
  
  //TODO: We need to implement a builder interface here

}

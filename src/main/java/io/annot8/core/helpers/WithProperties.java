package io.annot8.core.helpers;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
  	return listPropertyKeys().contains(key);
	}
	
	/**
	 * Return the property value for the specified key, if it exists
	 */
  default Optional<Object> getProperty(String key) {
  	return Optional.ofNullable( getProperties().get(key) );
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
  default Set<String> listPropertyKeys() {
  	return getProperties().keySet();
	}
	
	/**
	 * Return a map of all properties
	 */
  Map<String, Object> getProperties();
	
	/**
	 * Set the current properties to be equal to the map
	 */
  void setProperties(Map<String, Object> properties);
	
	/**
	 * Add all properties from the given map, overwriting values where they already exist
	 */
  void addProperties(Map<String, Object> properties);
	
	/**
	 * Remove all properties that match the given keys
	 */
  void removeProperties(Collection<String> keys);
}

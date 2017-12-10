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
	public boolean hasProperty(String key);
	
	/**
	 * Return the property value for the specified key, if it exists
	 */
	public Optional<Object> getProperty(String key);
	
	/**
	 * Return the property value for the specified key, or a default value if the key doesn't exist
	 */
	public Object getPropertyOrDefault(String key, Object defaultValue);
	
	/**
	 * Set the property value for the specified key
	 */
	public void setProperty(String key, Object value);
	
	/**
	 * Remove the property for the specified key, and return it's object (if it exists)
	 */
	public Optional<Object> removeProperty(String key);
	
	/**
	 * List the currently set property keys
	 */
	public Set<String> listPropertyKeys();
	
	/**
	 * Return a map of all properties
	 */
	public Map<String, Object> getProperties();
	
	/**
	 * Set the current properties to be equal to the map
	 */
	public void setProperties(Map<String, Object> properties);
	
	/**
	 * Add all properties from the given map, overwriting values where they already exist
	 */
	public void addProperties(Map<String, Object> properties);
	
	/**
	 * Remove all properties that match the given keys
	 */
	public void removeProperties(Collection<String> keys);
}

package io.annot8.core.helpers;

import java.util.Map;
import java.util.Set;

/**
 * Indicates that an object stores a collection of properties (key-value pairs)
 * 
 * Helper interface to reduce duplicate code.
 */
public interface WithProperties {
	public boolean hasProperty(String key);
	public Object getProperty(String key);
	public Object getPropertyOrDefault(String key, Object defaultValue);
	public void setProperty(String key, Object value);
	public Object removeProperty(String key);
	
	public Set<String> listPropertyKeys();
	
	public Map<String, Object> getProperties();
	public void setProperties(Map<String, Object> properties);
	public void addProperties(Map<String, Object> properties);
	public void removeProperties(Map<String, Object> properties);
}

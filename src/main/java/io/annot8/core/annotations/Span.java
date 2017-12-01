package io.annot8.core.annotations;

import java.util.Map;
import java.util.Set;

/**
 * Annotation to hold information about a specific part of the
 * document text, for instance a noun phrase or individual word
 * token.
 * 
 * Mentions of an {@link io.annot8.core.semantic.Entity} or
 * {@link io.annot8.core.semantic.Relation} should be referenced with
 * the {@link Mention} class, rather than this one.
 */
public interface Span extends Annotation {
	public String getType();
	public void setType(String type);
	
	public int getBegin();
	public void setBegin(int begin);
	public int getEnd();
	public void setEnd(int end);
	
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
	
	//TODO: Add a builder?
}

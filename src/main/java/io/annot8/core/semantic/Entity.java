package io.annot8.core.semantic;

import java.util.Map;
import java.util.Set;

import io.annot8.core.annotations.Mention;

/**
 * An Entity groups together one or more {@link Mention} that refer
 * to the same physical (or conceptual) item, for example a Person.
 */
public interface Entity {
	public String getType();
	public void setType(String type);
	
	public String getValue();
	public void setValue(String value);
	
	public void addMention(Mention mention);
	public boolean removeMention(Mention mention);
	public Set<Mention> getMentions();
	public void setMentions(Set<Mention> mentions);
	public void addMentions(Set<Mention> mentions);
	public void removeMentions(Set<Mention> mentions);
	
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

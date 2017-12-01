package io.annot8.core.semantic;

import java.util.Map;
import java.util.Set;

import io.annot8.core.annotations.Mention;

/**
 * A Relation groups together two or more {@link Entity} objects,
 * and zero or more {@link Mention} objects, where a relationship
 * of any kind exists between the entities.
 */
public interface Relation {
	public String getType();
	public void setType(String type);
	
	public void addEntity(Entity entity);
	public boolean removeEntity(Entity entity);
	public Set<Entity> getEntities();
	public void setEntities(Set<Entity> entity);
	public void addEntities(Set<Entity> entity);
	public void removeEntities(Set<Entity> entity);
	
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

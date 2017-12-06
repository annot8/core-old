package io.annot8.core.semantic;

import java.util.Set;

import io.annot8.core.annotations.Mention;
import io.annot8.core.helpers.WithMentions;
import io.annot8.core.helpers.WithProperties;

/**
 * A Relation groups together two or more {@link Entity} objects,
 * and zero or more {@link Mention} objects, where a relationship
 * of any kind exists between the entities.
 */
public interface Relation extends WithMentions, WithProperties {
	public String getType();
	public void setType(String type);
	
	public void addEntity(Entity entity);
	public boolean removeEntity(Entity entity);
	public Set<Entity> getEntities();
	public void setEntities(Set<Entity> entity);
	public void addEntities(Set<Entity> entity);
	public void removeEntities(Set<Entity> entity);
}

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
	String getType();
	void setType(String type);
	
	void addEntity(Entity entity);
	boolean removeEntity(Entity entity);
	Set<Entity> getEntities();
	void setEntities(Set<Entity> entity);
	void addEntities(Set<Entity> entity);
	void removeEntities(Set<Entity> entity);
}

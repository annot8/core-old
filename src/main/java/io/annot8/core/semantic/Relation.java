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
	default void setEntities(Set<Entity> entities) {
		removeEntities(getEntities());
		addEntities(entities);
	}
	default void addEntities(Set<Entity> entities) {
		entities.forEach(this::addEntity);

	}
	default void removeEntities(Set<Entity> entities) {
		entities.forEach(this::removeEntity);
	}
}

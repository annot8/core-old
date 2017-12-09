package io.annot8.core.semantic;

import java.util.Collection;
import java.util.Set;

import io.annot8.core.annotations.Mention;
import io.annot8.core.helpers.WithMentions;
import io.annot8.core.helpers.WithProperties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	Stream<Entity> getEntities();
	default void setEntities(Collection<Entity> entities) {
		removeEntities(getEntities().collect(Collectors.toList()));
		addEntities(entities);
	}
	default void addEntities(Collection<Entity> entities) {
		entities.forEach(this::addEntity);

	}
	default void removeEntities(Collection<Entity> entities) {
		entities.forEach(this::removeEntity);
	}
}

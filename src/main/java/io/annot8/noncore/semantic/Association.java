package io.annot8.noncore.semantic;

import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.noncore.helpers.WithMentions;
import io.annot8.noncore.overlays.Mention;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A Association groups together two or more {@link Entity} objects, and zero or more {@link Mention}
 * objects, where a relationship of any kind exists between the entities.
 */
public interface Association extends WithType, WithMentions, WithProperties {

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

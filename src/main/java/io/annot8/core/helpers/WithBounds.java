package io.annot8.core.helpers;

import java.util.Optional;

import io.annot8.core.bounds.Bounds;

public interface WithBounds {

	Bounds getBounds();
	default <T extends Bounds> Optional<T> getBounds(Class<T> clazz){
		Bounds bounds = getBounds();

		if(clazz.isInstance(bounds)) {
			return Optional.of(clazz.cast(bounds));
		}else {
			return Optional.empty();
		}
	}

	void setBounds(Bounds bound);
}

package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.content.Content;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.helpers.WithProperties;

public interface DataItem extends WithProperties {

	//Views
	void setDefaultView(String name);
	View<?> getDefaultView();

	default boolean hasView(String name) {
		return listViews().anyMatch(name::equals);
	}

	Stream<String> listViews();

	Optional<View<?>> getView(String name);

	Stream<View<?>> getViews();

	<T extends Content<?>> View<T> createView(String name, T content) throws AlreadyExistsException;
}

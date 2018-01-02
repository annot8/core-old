package io.annot8.core.documents;

import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.context.View;
import io.annot8.core.helpers.WithProperties;

public interface DataItem extends WithProperties {

	//Views
	View<?> getDefaultView();

	default boolean hasView(String name) {
		return listViews().anyMatch(name::equals);
	}

	Stream<String> listViews();

	Optional<View<?>> getView(String name);

	<T> View<T> createView(String name, Content<T> content);

	Optional<View<?>> removeView(String name);
}

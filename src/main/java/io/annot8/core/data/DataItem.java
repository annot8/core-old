package io.annot8.core.data;

import io.annot8.core.content.Content;
import io.annot8.core.helpers.WithProperties;

import java.util.Optional;
import java.util.stream.Stream;

public interface DataItem extends WithProperties {

	//Views
	void setDefaultView(View<?> view, String newKeyForOldView);
	View<?> getDefaultView();

	default boolean hasView(String name) {
		return listViews().anyMatch(name::equals);
	}

	Stream<String> listViews();

	Optional<View<?>> getView(String name);

	Stream<View<?>> getViews();

	<T> View<T> createView(String name, Content<T> content);

	Optional<View<?>> removeView(String name);
}

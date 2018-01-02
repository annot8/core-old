package io.annot8.core.context;

import io.annot8.core.documents.Content;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * An extended version of {@link Context} which is passed to processors in the process() function to
 * provide them with the annotation store and any other additional runtime information.
 */
public interface ProcessingContext extends Context {

	View getDefaultView();

	default boolean hasView(String name) {
		return listViews().anyMatch(name::equals);
	}

	Stream<String> listViews();

	Optional<View> getView(String name);

	View createView(String name, Content content);

	Optional<View> removeView(String name);

}

package io.annot8.core.context;

import java.util.Optional;

import io.annot8.core.documents.Document;
import java.util.Set;
import java.util.stream.Stream;

/**
 * An extended version of {@link Context} which is passed to processors in the
 * process() function to provide them with the annotation store and any other
 * additional runtime information.
 */
public interface ProcessingContext extends Context {

	ViewContext getDefaultView();

	default boolean hasView(String name) {
		return listViews().anyMatch(s -> name.equals(s));
	}

	Stream<String> listViews();
	Optional<ViewContext> getView(String name);
	ViewContext createView(String name, Document document);
	Optional<ViewContext> removeView(String name);

}

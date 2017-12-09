package io.annot8.core.context;

import java.util.Optional;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.documents.Document;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.core.stores.DocumentAnnotationStore;
import java.util.Set;

/**
 * An extended version of {@link Context} which is passed to processors in the
 * process() function to provide them with the annotation store and any other
 * additional runtime information.
 */
public interface ProcessingContext extends Context {

	boolean hasView(String name);
	Set<String> listViews();
	Optional<ViewContext> getView(String name);
	ViewContext createView(String name, Document document);
	Optional<ViewContext> removeView(String name);

}

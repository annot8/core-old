package io.annot8.core.stores;

import io.annot8.core.components.Resource;
import java.util.Set;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.context.Context;
import io.annot8.core.documents.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;

/**
 * Stores {@link Annotation} objects against {@link Document}s,
 * and allows retrieval of annotations associated with a given
 * document.
 * 
 * @param <T>
 * 		The type of {@link Annotation} stored by this store
 */
public interface AnnotationStore<T extends Annotation> extends Resource {

	void addAnnotation(T annotation);
	void updateAnnotation(T annotation);
	void removeAnnotation(T annotation);

	default void addAnnotations(Set<T> annotations) {
		annotations.forEach(this::addAnnotation);
	}
	default void updateAnnotations(Set<T> annotations)  {
		annotations.forEach(this::updateAnnotation);
	}
	default void removeAnnotations(Set<T> annotations)  {
		annotations.forEach(this::removeAnnotation);
	}

	default void removeAllAnnotations() {
		removeAnnotations(getAnnotations());
	}

	Set<T> getAnnotations();
	<U extends T> Set<U> getAnnotations(Class<U> annotationClass);
}

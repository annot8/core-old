package io.annot8.core.stores;

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
public interface AnnotationStore<T extends Annotation> extends AutoCloseable{
	void configure(Context context) throws BadConfigurationException, MissingResourceException;
	
	void addAnnotation(T annotation);
	void updateAnnotation(T annotation);
	void removeAnnotation(T annotation);

	void addAnnotations(Set<T> annotations);
	void updateAnnotations(Set<T> annotations);
	void removeAnnotations(Set<T> annotations);

	void removeAllAnnotations();

	Set<T> getAnnotations();
	<U extends T> Set<U> getAnnotations(Class<U> annotationClass);
}

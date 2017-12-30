package io.annot8.core.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.components.Resource;
import io.annot8.core.documents.Document;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	default void addAnnotations(Collection<T> annotations) {
		annotations.forEach(this::addAnnotation);
	}
	default void updateAnnotations(Collection<T> annotations)  {
		annotations.forEach(this::updateAnnotation);
	}
	default void removeAnnotations(Collection<T> annotations)  {
		annotations.forEach(this::removeAnnotation);
	}

	default void removeAllAnnotations() {
		removeAnnotations(getAnnotations().collect(Collectors.toList()));
	}

	Stream<T> getAnnotations();

	default  <U extends T> Stream<U> getAnnotations(Class<U> annotationClass) {
		return getAnnotations()
				.filter(annotationClass::isInstance)
				.map(annotationClass::cast);
	}
}

package io.annot8.core.annotations;

import java.util.Collection;
import java.util.stream.Stream;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

public interface AnnotationCollection<B extends Bounds> extends WithId, WithType, WithProperties {
	Stream<Annotation<B>> getAnnotations();
	
	void addAnnotation(Annotation<B> annotation);
	default void addAllAnnotations(Collection<Annotation<B>> annotations) {
		annotations.forEach(this::addAnnotation);
	}
	
	void removeAnnotation(Annotation<B> annotation);
	default void removeAllAnnotations(Collection<Annotation<B>> annotations) {
		annotations.forEach(this::removeAnnotation);
	}
}

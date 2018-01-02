package io.annot8.core.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Resource;
import io.annot8.core.documents.Document;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stores {@link Annotation} objects against {@link Document}s, and allows retrieval of annotations
 * associated with a given document.
 *
 * */
public interface AnnotationStore<B extends Bounds> extends Resource {

  <T> void addAnnotation(T annotation);

  <T> void updateAnnotation(T annotation);

  <T> void removeAnnotation(T annotation);

  default <T> void addAnnotations(Collection<T> annotations) {
    annotations.forEach(this::addAnnotation);
  }

  default <T> void updateAnnotations(Collection<T> annotations) {
    annotations.forEach(this::updateAnnotation);
  }

  default <T> void removeAnnotations(Collection<T> annotations) {
    annotations.forEach(this::removeAnnotation);
  }

  default void removeAllAnnotations() {
    removeAnnotations(getAnnotations().collect(Collectors.toList()));
  }

  Stream<? extends Annotation<B>> getAnnotations();

  default <T> Stream<T> getAnnotations(Class<T> annotationClass) {
    return getAnnotations()
        .filter(annotationClass::isInstance)
        .map(annotationClass::cast);
  }
}

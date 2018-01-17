package io.annot8.core.annotations;

import java.util.Collection;
import java.util.stream.Stream;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

// TODO: This needs more thought. How does it get stored? Is it linked to a specific view, or does
// it sit above them?
public interface AnnotationCollection extends WithId, WithType, WithProperties {
  Stream<Annotation<?>> getAnnotations();

  void addAnnotation(Annotation<?> annotation);

  default void addAllAnnotations(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::addAnnotation);
  }

  void removeAnnotation(Annotation<?> annotation);

  default void removeAllAnnotations(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::removeAnnotation);
  }

  boolean containsAnnotation(Annotation<?> annotation);
}

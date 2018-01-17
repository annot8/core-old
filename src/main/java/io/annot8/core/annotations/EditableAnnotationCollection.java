package io.annot8.core.annotations;

import java.util.Collection;
import io.annot8.core.helpers.Saveable;


public interface EditableAnnotationCollection
    extends AbstractAnnotationCollection, Saveable<AnnotationCollection> {

  void setType(String type);

  void addAnnotation(Annotation<?> annotation);

  default void addAllAnnotations(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::addAnnotation);
  }

  void removeAnnotation(Annotation<?> annotation);

  default void removeAllAnnotations(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::removeAnnotation);
  }

}

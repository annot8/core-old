package io.annot8.core.annotations;

import java.util.Collection;
import io.annot8.core.helpers.Saveable;


public interface EditableAnnotationCollection
    extends AbstractAnnotationCollection, Saveable<AnnotationCollection> {

  void setType(String type);

  void add(Annotation<?> annotation);

  default void add(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::add);
  }

  void remove(Annotation<?> annotation);

  default void remove(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::remove);
  }

}

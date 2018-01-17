package io.annot8.core.stores;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.annotations.EditableAnnotationCollection;

public interface AnnotationCollections {

  EditableAnnotationCollection create();

  AnnotationCollection save(EditableAnnotationCollection annotation);

  void delete(AnnotationCollection annotation);

  default void save(final Collection<EditableAnnotationCollection> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(final Collection<AnnotationCollection> annotations) {
    annotations.forEach(this::delete);
  }

  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<AnnotationCollection> getAll();

  default Stream<AnnotationCollection> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }
}

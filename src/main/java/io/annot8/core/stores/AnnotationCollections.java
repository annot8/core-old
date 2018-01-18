package io.annot8.core.stores;

import java.util.Collection;
import java.util.Optional;
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
    delete(stream().collect(Collectors.toList()));
  }

  Stream<AnnotationCollection> stream();

  default Stream<AnnotationCollection> getByType(final String type) {
    return stream().filter(a -> type.equals(a.getType()));
  }

  Optional<AnnotationCollection> getById(String id);

}

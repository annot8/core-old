package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.annotations.AnnotationCollection;

public interface AnnotationCollections {

  AnnotationCollection create();

  void save(AnnotationCollection annotation);

  void delete(AnnotationCollection annotation);

  default void save(final Collection<AnnotationCollection> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(final Collection<AnnotationCollection> annotations) {
    annotations.forEach(this::delete);
  }

  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  // TODO: Call this stream?!?!
  Stream<AnnotationCollection> getAll();

  default Stream<AnnotationCollection> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }
}

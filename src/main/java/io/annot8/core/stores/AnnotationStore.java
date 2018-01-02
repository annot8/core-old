package io.annot8.core.stores;

import io.annot8.core.annotations.Annotation;
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
public interface AnnotationStore extends Resource {

  Annotation create();

  void save(Annotation annotation);

  void delete(Annotation annotation);

  default void save(Collection<Annotation> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(Collection<Annotation> annotations) {
    annotations.forEach(this::delete);
  }

  default void removeAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<Annotation> getAll();

  default Stream<Annotation> getByType(String type) {
    return getAll()
        .filter(a -> type.equals(a.getType()));
  }

}

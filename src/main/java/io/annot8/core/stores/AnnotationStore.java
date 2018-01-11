package io.annot8.core.stores;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.content.Text;

/**
 * Stores {@link Annotation} objects against {@link Text}s, and allows retrieval of annotations
 * associated with a given document.
 */
public interface AnnotationStore<B extends Bounds> {

  Annotation<B> createNew(B bounds);

  void save(Annotation<B> annotation);

  void delete(Annotation<B> annotation);

  default void save(final Collection<Annotation<B>> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(final Collection<Annotation<B>> annotations) {
    annotations.forEach(this::delete);
  }

  default void removeAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<Annotation<B>> getAll();

  default Stream<Annotation<B>> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

}

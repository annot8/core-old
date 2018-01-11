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
public interface AnnotationStore<B extends Bounds, A extends Annotation<B>> {

  A createNew(B bounds);

  void save(A annotation);

  void delete(A annotation);

  default void save(final Collection<A> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(final Collection<A> annotations) {
    annotations.forEach(this::delete);
  }

  default void removeAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<A> getAll();

  default Stream<A> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

}

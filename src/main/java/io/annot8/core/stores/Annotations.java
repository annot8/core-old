package io.annot8.core.stores;

import io.annot8.content.text.Text;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.exceptions.IncompleteException;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stores {@link Annotation} objects against {@link Text}s, and allows retrieval of annotations
 * associated with a given document.
 */
public interface Annotations<B extends Bounds, A extends Annotation<B>> {

  A.Builder<A, B> getBuilder();
  A save(A.Builder<A, B> annotationBuilder) throws IncompleteException;

  void delete(A annotation);

  default void delete(final Collection<A> annotations) {
    annotations.forEach(this::delete);
  }

  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<A> getAll();

  default Stream<A> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

  Optional<A> getById(String annotationId);

}

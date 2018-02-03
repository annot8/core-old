package io.annot8.core.stores;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.exceptions.IncompleteException;

/**
 * Base annotations interface from which all other annotation stores extend.
 * 
 * @param <B>
 * 		The bounds supported by this store
 * @param <A>
 * 		The annotation supported by this store, which must use the given bounds
 */
public interface AnnotationStore<B extends Bounds, A extends Annotation<B>> {

  /**
   * Return a builder object for the supported annotations
   */
  A.Builder<A, B> getBuilder();

  /**
   * Save an annotation to the store from an annotation builder
   */
  A save(final A.Builder<A, B> annotationBuilder) throws IncompleteException;

  /**
   * Delete an annotation from the store
   */
  void delete(final A annotation);

  /**
   * Delete a collection of annotations from the store
   */
  default void delete(final Collection<A> annotations) {
    annotations.forEach(this::delete);
  }

  /**
   * Delete all annotations from the store
   */
  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  /**
   * Get all annotations currently held in this store
   */
  Stream<A> getAll();

  /**
   * Get all annotations of a given type currently held in this store
   */
  default Stream<A> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

  /**
   * Get the annotation with the given ID, if it is currently held in this store
   */
  Optional<A> getById(final String annotationId);

}

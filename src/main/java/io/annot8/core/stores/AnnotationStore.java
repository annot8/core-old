package io.annot8.core.stores;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.exceptions.IncompleteException;
import io.annot8.core.exceptions.UnsupportedException;

/**
 * Base annotations interface from which all other annotation stores extend.
 */
public interface AnnotationStore {

  /**
   * Return a builder object for the specified annotation class
   */
  <A extends Annotation> A.Builder getBuilder(final Class<A> annotationClass) throws UnsupportedException;

  /**
   * Save an annotation to the store from an annotation builder
   */
  <A extends Annotation> A save(final A.Builder annotationBuilder) throws IncompleteException, UnsupportedException;

  /**
   * Return true if this store supports creating and saving the specified annotation class
   */
  boolean supports(Class<? extends Annotation> annotationClass);
  
  /**
   * Delete an annotation from the store
   */
  void delete(final Annotation annotation);

  /**
   * Delete a collection of annotations from the store
   */
  default void delete(final Collection<Annotation> annotations) {
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
  Stream<Annotation> getAll();

  /**
   * Get all annotations of a given class held in this store
   */
  <A extends Annotation> Stream<A> getAll(final Class<A> annotationClass);
  
  /**
   * Get all annotations of a given bounds held in this store
   */
  <B extends Bounds> Stream<Annotation<B>> getAllByBounds(final Class<B> boundsClass);
  
  /**
   * Get all annotations of a given type currently held in this store
   */
  default Stream<Annotation> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }
  
  /**
   * Get all annotations of a given type and class currently held in this store
   */
  default <A extends Annotation> Stream<A> getByType(final String type, final Class<A> annotationClass) {
    return getAll(annotationClass).filter(a -> type.equals(a.getType()));
  }
  
  /**
   * Get all annotations of a given type and bounds currently held in this store
   */
  default <B extends Bounds> Stream<Annotation<B>> getByTypeAndBounds(final String type, final Class<B> boundsClass) {
    return getAllByBounds(boundsClass).filter(a -> type.equals(a.getType()));
  }

  /**
   * Get the annotation with the given ID, if it is currently held in this store
   */
  Optional<Annotation> getById(final String annotationId);
  
  /**
   * Get the annotation of the given class with the given ID, if it is currently held in this store
   */
  <A extends Annotation> Optional<A> getById(final String annotationId, final Class<A> annotationClass);

}

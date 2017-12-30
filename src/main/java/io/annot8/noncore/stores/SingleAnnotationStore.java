package io.annot8.noncore.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.bounds.Bounds;
import io.annot8.core.documents.Document;
import io.annot8.core.stores.AnnotationStore;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stores {@link Annotation} objects against {@link Document}s, and allows retrieval of annotations
 * associated with a given document.
 *
 * @param <T> The type of {@link Annotation} stored by this store
 */
public class SingleAnnotationStore<B extends Bounds, T extends Annotation<B>> {

  private final AnnotationStore<B> annotationStore;
  private final Class<T> annotationClazz;

  public SingleAnnotationStore(AnnotationStore<B> annotationStore, Class<T> annotationClazz) {
    this.annotationStore = annotationStore;
    this.annotationClazz = annotationClazz;
  }

  public void addAnnotation(T annotation) {
    annotationStore.addAnnotation(annotation);
  }

  public void updateAnnotation(T annotation) {
    annotationStore.updateAnnotation(annotation);
  }

  public void removeAnnotation(T annotation) {
    annotationStore.removeAnnotation(annotation);
  }

  public void addAnnotations(Collection<T> annotations) {
    annotationStore.addAnnotations(annotations);
  }

  public void updateAnnotations(Collection<T> annotations) {
    annotationStore.updateAnnotations(annotations);
  }

  public void removeAnnotations(Collection<T> annotations) {
    annotationStore.removeAnnotations(annotations);
  }

  public void removeAllAnnotations() {
    removeAnnotations(getAnnotations(annotationClazz).collect(Collectors.toList()));
  }

  public Stream<T> getAnnotations() {
    return annotationStore.getAnnotations(annotationClazz);
  }

  public <U extends T> Stream<U> getAnnotations(Class<U> annotationSubClass) {
    return annotationStore.getAnnotations(annotationSubClass);
  }
}

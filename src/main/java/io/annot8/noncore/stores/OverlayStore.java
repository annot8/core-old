package io.annot8.noncore.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.Overlay;
import io.annot8.core.documents.Document;
import io.annot8.core.stores.AnnotationStore;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Stores {@link Annotation} objects against {@link Document}s, and allows retrieval of annotations
 * associated with a given document.
 *
 * @param <T> The type of {@link Annotation} stored by this store
 */
public class OverlayStore<T extends Overlay> {

  private final String annotationType;
  private final AnnotationStore annotationStore;
  private final Class<T> overlayClazz;
  private final Constructor<T> constructor;

  public OverlayStore(String annotationType, AnnotationStore annotationStore, Class<T> overlayClazz)
      throws NoSuchMethodException {
    this.annotationType = annotationType;
    this.annotationStore = annotationStore;
    this.overlayClazz = overlayClazz;
    this.constructor = overlayClazz.getConstructor(Annotation.class);
  }


  public T create() {
    Annotation a = annotationStore.create();
    return create(a);
  }

  public T create(Annotation annotation) {
    try {
      return constructor.newInstance(annotation);
    } catch (Exception e) {
      throw new RuntimeException("Not a valid overlay", e);
    }
  }

  public void save(T overlay) {
    annotationStore.save(overlay.getAnnotation());
  }

  public void delete(T overlay) {
    annotationStore.delete(overlay.getAnnotation());
  }

  public void save(Collection<T> overlays) {
    overlays.forEach(this::save);
  }

  public void delete(Collection<T> overlays) {
    overlays.forEach(this::delete);
  }

  public Stream<T> getAnnotations() {
    return annotationStore.getByType(annotationType).map(this::create);
  }

}

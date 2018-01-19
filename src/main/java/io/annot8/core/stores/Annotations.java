package io.annot8.core.stores;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.content.text.Text;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.EditableAnnotation;
import io.annot8.core.bounds.Bounds;

/**
 * Stores {@link Annotation} objects against {@link Text}s, and allows retrieval of annotations
 * associated with a given document.
 */
public interface Annotations<B extends Bounds, A extends Annotation<B>, E extends EditableAnnotation<B>> {

  E create(B bounds);

  Stream<A> stream();

  default Stream<A> getByType(final String type) {
    return stream().filter(a -> type.equals(a.getType()));
  }

  Optional<A> getById(String annotationId);

}

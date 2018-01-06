package io.annot8.core.stores;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.content.Text;
import io.annot8.core.data.View;

/**
 * Stores {@link Annotation} objects against {@link Text}s, and allows retrieval of annotations
 * associated with a given document.
 */
public interface AnnotationStore extends Annot8Component {

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

  default Stream<Annotation> getByView(View<?> view) {
    return getAll()
            .filter(a -> view.equals(a.getView()));
  }

  default Stream<Annotation> getByViewAndType(View<?> view, String type) {
    return getAll()
            .filter(a -> view.equals(a.getView()))
            .filter(a -> type.equals(a.getType()));
  }

}

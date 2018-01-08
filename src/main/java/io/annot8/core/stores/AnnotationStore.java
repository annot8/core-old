package io.annot8.core.stores;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.content.Text;
import io.annot8.core.data.View;

/**
 * Stores {@link Annotation} objects against {@link Text}s, and allows retrieval of annotations
 * associated with a given document.
 */
public interface AnnotationStore extends Annot8Component {

  //Annotation<? extends Bounds> createNew(View<?> view, Bounds bounds);	//TODO: Ideally, the generics here would be such that you know what type of Annotation you're getting back
  <T extends Bounds> Annotation<T> createNew(View<?> view, T bounds);
	
  void save(Annotation<? extends Bounds> annotation);

  void delete(Annotation<? extends Bounds> annotation);

  default void save(Collection<Annotation<? extends Bounds>> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(Collection<Annotation<? extends Bounds>> annotations) {
    annotations.forEach(this::delete);
  }

  default void removeAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<Annotation<? extends Bounds>> getAll();

  default Stream<Annotation<? extends Bounds>> getByType(String type) {
    return getAll()
        .filter(a -> type.equals(a.getType()));
  }

  default Stream<Annotation<? extends Bounds>> getByView(View<?> view) {
    return getAll()
            .filter(a -> view.equals(a.getView()));
  }

  default Stream<Annotation<? extends Bounds>> getByViewAndType(View<?> view, String type) {
    return getAll()
            .filter(a -> view.equals(a.getView()))
            .filter(a -> type.equals(a.getType()));
  }

}

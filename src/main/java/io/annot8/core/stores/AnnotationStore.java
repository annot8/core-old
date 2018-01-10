package io.annot8.core.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stores {@link Annotation} objects against {@link Text}s, and allows retrieval of annotations
 * associated with a given document.
 */
public interface AnnotationStore extends Annot8Component {

  //Annotation<? extends Bounds> createNew(Content<?> content, Bounds bounds);	//TODO: Ideally, the generics here would be such that you know what type of Annotation you're getting back
  <T extends Bounds> Annotation<T> createNew(Content<?> content, T bounds);
	
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

  default Stream<Annotation<? extends Bounds>> getByContent(Content<?> content) {
    return getAll()
            .filter(a -> content.equals(a.getContent()));
  }

  default Stream<Annotation<? extends Bounds>> getByContentAndType(Content<?> content, String type) {
    return getAll()
            .filter(a -> content.equals(a.getContent()))
            .filter(a -> type.equals(a.getType()));
  }

}

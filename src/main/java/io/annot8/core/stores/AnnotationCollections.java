package io.annot8.core.stores;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.annotations.AnnotationReference;
import io.annot8.core.annotations.EditableAnnotationCollection;

public interface AnnotationCollections {

  EditableAnnotationCollection create();

  Stream<AnnotationCollection> stream();

  default Stream<AnnotationCollection> getByType(final String type) {
    return stream().filter(a -> type.equals(a.getType()));
  }

  Optional<AnnotationCollection> getById(String id);

  // TODO: Getting a reference should never fail??? (ie no need for optional
  AnnotationReference toReference(Annotation<?> annotation);

  Optional<Annotation<?>> toAnnotation(AnnotationReference reference);

  default Stream<AnnotationReference> toReferences(final Stream<Annotation<?>> annotations) {
    return annotations.map(this::toReference);
  }

  default Stream<Annotation<?>> toAnnotations(final Stream<AnnotationReference> references) {
    return references.map(this::toAnnotation).filter(Optional::isPresent).map(Optional::get);

  }

}

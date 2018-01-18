package io.annot8.core.annotations;

import java.util.Set;
import java.util.stream.Stream;
import io.annot8.core.helpers.Deletable;
import io.annot8.core.helpers.Editable;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

// TODO: CF I think this should be called Annotations that's nicer with Annotation
// TODO: This needs more thought. How does it get stored? Is it linked to a specific view, or does
// it sit above them?
public interface AnnotationCollection
    extends WithId, WithType, WithProperties, Editable<EditableAnnotationCollection>, Deletable {

  boolean contains(Annotation<?> annotation);

  Stream<Annotation<?>> stream();

  default Stream<AnnotationReference> streamReferences() {
    return asSet().stream();
  }

  default boolean contains(final AnnotationReference annotation) {
    return asSet().contains(annotation);
  }

  Set<AnnotationReference> asSet();


}

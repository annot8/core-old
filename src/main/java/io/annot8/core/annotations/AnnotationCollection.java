package io.annot8.core.annotations;

import java.util.Set;
import java.util.stream.Stream;
import io.annot8.core.helpers.Deletable;
import io.annot8.core.helpers.Editable;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

// TODO: CF I think this should be called Annotations, Associations, Groups, something - that's
// nicer with Annotation. ANnotationCollection is a handful
// and might be a bit confusing in Java terminoloy since we have Collection<Annotation> collection /
// AnnotationCollection collection in places!
public interface AnnotationCollection
    extends WithId, WithType, WithProperties, Editable<EditableAnnotationCollection>, Deletable {

  boolean contains(final Annotation<?> annotation);

  Stream<Annotation<?>> stream();

  default Stream<AnnotationReference> streamReferences() {
    return asSet().stream();
  }

  default boolean contains(final AnnotationReference annotation) {
    return asSet().contains(annotation);
  }

  Set<AnnotationReference> asSet();

}

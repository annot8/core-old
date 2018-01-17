package io.annot8.core.annotations;

import java.util.stream.Stream;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

// TODO: CF I think this should be called Annotations that's nicer with Annotation
// TODO: This needs more thought. How does it get stored? Is it linked to a specific view, or does
// it sit above them?
public interface AbstractAnnotationCollection extends WithId, WithType, WithProperties {
  Stream<Annotation<?>> getAnnotations();

  boolean containsAnnotation(Annotation<?> annotation);
}

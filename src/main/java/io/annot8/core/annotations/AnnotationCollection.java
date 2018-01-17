package io.annot8.core.annotations;

import io.annot8.core.helpers.Deletable;
import io.annot8.core.helpers.Editable;

// TODO: CF I think this should be called Annotations that's nicer with Annotation
// TODO: This needs more thought. How does it get stored? Is it linked to a specific view, or does
// it sit above them?
public interface AnnotationCollection extends AbstractAnnotationCollection,
    Editable<AnnotationCollection, EditableAnnotationCollection>, Deletable {

}

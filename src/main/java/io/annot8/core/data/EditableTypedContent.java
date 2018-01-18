package io.annot8.core.data;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.EditableAnnotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.Annotations;

public interface EditableTypedContent<B extends Bounds, A extends Annotation<B>, E extends EditableAnnotation<B>, S extends Annotations<B, A, E>, D>
    extends TypedContent<B, A, E, S, D>, EditableContent<D> {


}

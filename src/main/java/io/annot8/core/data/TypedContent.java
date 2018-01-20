package io.annot8.core.data;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.Annotations;

public interface TypedContent<B extends Bounds, A extends Annotation<B>, S extends Annotations<B, A>, D>
    extends Content<D> {


  @Override
  S getAnnotations();
}

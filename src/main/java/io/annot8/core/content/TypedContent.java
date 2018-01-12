package io.annot8.core.content;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.Annotations;

public interface TypedContent<B extends Bounds, A extends Annotation<B>, S extends Annotations<B, A>, D>
    extends Content {

  // TODO: Do we want this here, vs having a more specific getText etc on Text interface?
  @Override
  D getData();

  @Override
  S getAnnotations();
}

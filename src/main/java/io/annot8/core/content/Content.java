package io.annot8.core.content;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.WithTags;
import io.annot8.core.stores.AnnotationStore;

public interface Content<B extends Bounds, D> extends WithTags {

  // TODO: Do we want this here, vs having a more specific getText etc on Text interface?
  D getData();

  AnnotationStore<B> getAnnotationStore();
}

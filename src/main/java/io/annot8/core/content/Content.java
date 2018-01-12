package io.annot8.core.content;

import io.annot8.core.helpers.WithTags;
import io.annot8.core.stores.Annotations;

public interface Content extends WithTags {

  // TODO: Do we want this...
  Object getData();

  Annotations<?, ?> getAnnotations();
}

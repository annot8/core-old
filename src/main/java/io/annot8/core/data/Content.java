package io.annot8.core.data;

import io.annot8.core.helpers.WithTags;

public interface Content extends WithTags {

  // TODO: Do we want this...
  Object getData();

  Annotations<?, ?> getAnnotations();
}

package io.annot8.core.data;

import io.annot8.core.helpers.WithTags;

public interface Content<D> extends WithTags {

  // TODO: Do we want this...
  D getData();

  Annotations<?, ?> getAnnotations();

  String getName();
}

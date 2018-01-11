package io.annot8.core.content;

import io.annot8.core.helpers.WithTags;

public interface Content<T> extends WithTags {

  // TODO: Do we want this here, vs having a more specific getText etc on Text interface?
  T getData();
}

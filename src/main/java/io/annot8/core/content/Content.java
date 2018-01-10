package io.annot8.core.content;

import io.annot8.core.helpers.WithTags;

public interface Content<T> extends WithTags {
  T getContent();
}

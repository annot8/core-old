package io.annot8.core.data;

import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithTags;
import io.annot8.core.stores.Annotations;

public interface Content<D> extends WithTags, WithProperties {

  D getData();

  Annotations<?, ?, ?> getAnnotations();

  String getName();
}

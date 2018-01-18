package io.annot8.core.data;

import io.annot8.core.helpers.Editable;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithTags;
import io.annot8.core.stores.Annotations;

public interface Content<D> extends WithTags, WithProperties, Editable<Content<D>, EditableContent<D>> {

  D getData();

  Annotations<?, ?, ?> getAnnotations();

  String getName();
}

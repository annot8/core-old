package io.annot8.core.data;

import io.annot8.core.helpers.Saveable;
import io.annot8.core.helpers.WithEditableProperties;
import io.annot8.core.helpers.WithEditableTags;
import io.annot8.core.stores.Annotations;

public interface EditableContent<D> extends WithEditableTags, WithEditableProperties, Saveable<Content<D>> {

  D getData();

  Annotations<?, ?, ?> getAnnotations();

  String getName();

  // TODO: setData
}

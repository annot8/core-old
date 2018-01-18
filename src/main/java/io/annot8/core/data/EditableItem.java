package io.annot8.core.data;

import io.annot8.core.helpers.Saveable;
import io.annot8.core.helpers.WithEditableProperties;

public interface EditableItem extends Item, WithEditableProperties, Saveable<Item> {

  @Override
  default EditableItem edit() {
    return this;
  }

}

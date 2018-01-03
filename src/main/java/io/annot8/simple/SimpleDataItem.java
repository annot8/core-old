package io.annot8.simple;

import java.util.Optional;

import io.annot8.core.data.DataItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleDataItem extends SimpleProperties implements DataItem {

  private final Optional<DataItem> parent;

  private final String id;

  public SimpleDataItem(final String id) {
    this(null, id);
  }

  public SimpleDataItem(final DataItem parent, final String id) {
    this.parent = Optional.ofNullable(parent);
    this.id = id;
  }
}

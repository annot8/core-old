package io.annot8.simple;

import java.util.Optional;

import io.annot8.core.data.DataItem;
import lombok.Data;

@Data
public class SimpleDataItem implements DataItem {

  private final Optional<DataItem> parent;

  private final String id;

  private SimpleProperties properties = new SimpleProperties();

  public SimpleDataItem(final String id) {
    this(null, id);
  }

  public SimpleDataItem(final DataItem parent, final String id) {
    this.parent = Optional.ofNullable(parent);
    this.id = id;
  }
}

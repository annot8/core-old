package io.annot8.simple;

import io.annot8.core.data.DataItem;
import java.util.Optional;
import lombok.Data;

@Data
public class SimpleDataItem extends SimpleProperties implements DataItem {

  private final Optional<DataItem> parent;

  private final String id;

  public SimpleDataItem(String id) {
    this(null, id);
  }

  public SimpleDataItem(DataItem parent, String id) {
    this.parent = Optional.ofNullable(parent);
    this.id = id;
  }
}

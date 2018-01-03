package io.annot8.pipeline.atomizers;

import java.util.stream.Stream;

import io.annot8.core.data.DataItem;
import io.annot8.pipeline.dataitems.DirectoryDataItem;

public class DirectoryAtomizer extends AbstractClassAtomizer<DirectoryDataItem> {

  public DirectoryAtomizer() {
    super(DirectoryDataItem.class);
  }

  @Override
  public Stream<DataItem> convertItem(DirectoryDataItem item) {
    // We recursie to ourselves in order to process out all the content
    return item.list();
  }
}

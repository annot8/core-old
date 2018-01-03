package io.annot8.pipeline.dataitems;

import java.io.File;

import io.annot8.core.data.DataItem;
import io.annot8.simple.SimpleDataItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FileDataItem extends SimpleDataItem {

  private final File file;

  public FileDataItem(final DataItem parent, final File file) {
    super(parent, file.getAbsolutePath());
    this.file = file;
  }

  public FileDataItem(final File directory) {
    this(null, directory);
  }

}

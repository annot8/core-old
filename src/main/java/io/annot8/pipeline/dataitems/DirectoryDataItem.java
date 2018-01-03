package io.annot8.pipeline.dataitems;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import io.annot8.core.data.DataItem;
import io.annot8.simple.SimpleDataItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DirectoryDataItem extends SimpleDataItem {

  private final File directory;

  public DirectoryDataItem(final DataItem parent, final File directory) {
    super(parent, directory.getAbsolutePath());
    this.directory = directory;
  }

  public DirectoryDataItem(final File directory) {
    this(null, directory);
  }

  public Stream<DataItem> list() {
    return Arrays.stream(directory.listFiles())
        .map(f -> {
          if (f.isDirectory()) {
            return new DirectoryDataItem(this, f);
          } else {
            return new FileDataItem(this, f);
          }
        });
  }
}

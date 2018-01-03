package io.annot8.pipeline.dataitems;

import io.annot8.core.data.DataItem;
import io.annot8.simple.SimpleDataItem;
import io.annot8.simple.SimpleProperties;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.Data;

@Data
public class DirectoryDataItem extends SimpleDataItem  {

  private final File directory;

  public DirectoryDataItem(DataItem parent, File directory) {
    super(parent, directory.getAbsolutePath());
    this.directory = directory;
  }

  public DirectoryDataItem(File directory) {
    this(null, directory);
  }

  public Stream<DataItem> list() {
      return Arrays.stream(directory.listFiles())
          .map(f -> {
            if(f.isDirectory()) {
              return new DirectoryDataItem(this, f);
            } else {
              return new FileDataItem(this, f);
            }
          });
  }
}

package io.annot8.pipeline.dataitems;

import io.annot8.core.content.Content;
import io.annot8.core.data.DataItem;
import io.annot8.simple.SimpleDataItem;
import io.annot8.simple.SimpleProperties;
import java.io.File;
import java.io.InputStream;
import java.util.Optional;
import lombok.Data;

@Data
public class FileDataItem extends SimpleDataItem {

  private final File file;

  public FileDataItem(DataItem parent, File file) {
    super(parent, file.getAbsolutePath());
    this.file = file;
  }

  public FileDataItem(File directory) {
    this(null, directory);
  }

}

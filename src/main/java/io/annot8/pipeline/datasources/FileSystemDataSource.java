package io.annot8.pipeline.datasources;

import java.io.File;
import java.util.stream.Stream;

import io.annot8.core.components.DataSource;
import io.annot8.core.data.DataItem;
import io.annot8.pipeline.dataitems.DirectoryDataItem;

public class FileSystemDataSource implements DataSource {

  private final File rootDirectory;

  public FileSystemDataSource(File rootDirectory) {
    // TODO: This should be set via configuration
    this.rootDirectory = rootDirectory;
  }

  @Override
  public Stream<DataItem> getDataItems() {
   // perhaps a bit crazy but we just return a single thing.
   // I think it reality we should recursive here to output
   // all the files etc we want processed, but this is an interesting
   // use case for the DataItem spiltting.
   return Stream.of(new DirectoryDataItem(rootDirectory));
  }

}

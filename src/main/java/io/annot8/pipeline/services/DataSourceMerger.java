package io.annot8.pipeline.services;

import java.util.List;
import java.util.stream.Stream;

import io.annot8.core.components.DataSource;
import io.annot8.core.data.DataItem;

public class DataSourceMerger {

  private final List<DataSource> sources;

  public DataSourceMerger(List<DataSource> sources) {
    this.sources = sources;
  }

  public Stream<DataItem> merge() {
    return combineStreams();
  }

  private Stream<DataItem> combineStreams() {

    // TODO: Be better to round robin / other implementaions but we just create a long stream...
    // I suspect that stream is not the right interface here... I was Flux but its a depednence we'd need to add for DataSource.


    Stream<DataItem> combinedStream = null;
    for(DataSource ds : sources) {

      Stream<DataItem> stream = ds.getDataItems();

      if(stream != null) {
        if(combinedStream == null) {
          combinedStream = stream;
        } else {
          combinedStream = Stream.concat(combinedStream, stream);
        }
      }
    }


    return combinedStream == null ? Stream.empty() : combinedStream;
  }
}

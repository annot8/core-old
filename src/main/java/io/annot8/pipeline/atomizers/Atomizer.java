package io.annot8.pipeline.atomizers;

import java.util.stream.Stream;

import io.annot8.core.data.DataItem;

public interface Atomizer {

  boolean accepts(DataItem content);

  Stream<DataItem> divide(DataItem dataItem);

}

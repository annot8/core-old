package io.annot8.pipeline.atomizers;

import java.util.stream.Stream;

import io.annot8.core.data.DataItem;

// TODO: I think this is irrelevant all dataitems should be kept and converter decides what gets discarded / output. So delete.
public class KeepAllAtomizer implements  Atomizer {

  @Override
  public boolean accepts(DataItem content) {
    return true;
  }

  @Override
  public Stream<DataItem> divide(DataItem dataItem) {
    return Stream.of(dataItem);
  }
}

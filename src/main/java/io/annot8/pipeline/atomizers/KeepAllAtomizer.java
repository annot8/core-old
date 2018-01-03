package io.annot8.pipeline.atomizers;

import io.annot8.core.data.DataItem;
import java.util.stream.Stream;

public class KeepAllAtomizer implements  Atomizer {

  @Override
  public boolean accepts(DataItem content) {
    return true;
  }

  @Override
  public Stream<DataItem> convert(DataItem dataItem) {
    return Stream.of(dataItem);
  }
}

package io.annot8.pipeline.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import io.annot8.core.data.DataItem;
import io.annot8.pipeline.atomizers.Atomizer;

public class DataItemAtomizer implements Function<DataItem, Stream<DataItem>> {

  private final List<Atomizer> atomizers;

  public DataItemAtomizer(List<Atomizer> atomizers) {
    this.atomizers = atomizers;
  }


  @Override
  public Stream<DataItem> apply(DataItem dataItem) {

    for (Atomizer atomizer : atomizers) {
      if (atomizer.accepts(dataItem)) {
        Stream<DataItem> stream = atomizer.divide(dataItem);

        // TODO: If we've processed this we one content converter, is that enough?
        return stream;
      }
    }

    // If we've not matched... then discard (use the KeepAtomizer to include everything)
    return Stream.empty();
  }
}

package io.annot8.pipeline.atomizers;

import io.annot8.core.data.DataItem;
import java.util.stream.Stream;

public interface Atomizer {

  boolean accepts(DataItem content);

  Stream<DataItem> convert(DataItem dataItem);

}

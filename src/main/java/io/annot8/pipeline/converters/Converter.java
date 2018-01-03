package io.annot8.pipeline.converters;

import java.util.Optional;

import io.annot8.core.data.DataItem;
import io.annot8.core.data.Document;

public interface Converter {

  boolean supports(DataItem dataItem);

  Optional<Document>  convert(DataItem dataItem);
}

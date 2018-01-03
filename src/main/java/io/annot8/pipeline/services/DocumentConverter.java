package io.annot8.pipeline.services;

import java.util.List;
import java.util.Optional;

import io.annot8.core.data.DataItem;
import io.annot8.core.data.Document;
import io.annot8.pipeline.converters.Converter;

public class DocumentConverter {

  private final List<Converter> converters;

  public DocumentConverter(List<Converter> converters) {
    this.converters = converters;
  }

  public Optional<Document> convert(DataItem item) {
    for (Converter c : converters) {
      if (c.supports(item)) {
        Optional<Document> optional = c.convert(item);

        if (optional.isPresent()) {
          return optional;
        }
      }
    }

    return Optional.empty();
  }
}

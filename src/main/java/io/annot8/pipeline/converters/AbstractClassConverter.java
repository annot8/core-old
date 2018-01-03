package io.annot8.pipeline.converters;

import java.util.Optional;

import io.annot8.core.data.DataItem;
import io.annot8.core.data.Document;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractClassConverter<T extends DataItem> implements Converter {

  private final Class<T> clazz;

  public AbstractClassConverter(final Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public boolean supports(final DataItem item) {
    return clazz.isInstance(item);
  }

  @Override
  public final Optional<Document> convert(final DataItem item) {
    // its checked by supports in theory but an overridder might not.
    if (clazz.isInstance(item)) {
      return convert(item);
    } else {
      log.warn("Not correct class to convert");
      return Optional.empty();
    }
  }

  protected abstract Optional<Document> convertItem(T item);
}

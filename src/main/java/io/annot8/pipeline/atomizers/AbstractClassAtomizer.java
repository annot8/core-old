package io.annot8.pipeline.atomizers;

import java.util.stream.Stream;

import io.annot8.core.data.DataItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractClassAtomizer<T extends DataItem> implements Atomizer {

  private final Class<T> clazz;

  public AbstractClassAtomizer(final Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public boolean accepts(final DataItem item) {
    return clazz.isInstance(item);
  }

  @Override
  public final Stream<DataItem> divide(final DataItem item) {
    // its checked by supports in theory but an overridder might not.
    if (clazz.isInstance(item)) {
      return divide(item);
    } else {
      log.warn("Not correct class to convert");
      return Stream.empty();
    }
  }

  protected abstract Stream<DataItem> convertItem(T item);
}

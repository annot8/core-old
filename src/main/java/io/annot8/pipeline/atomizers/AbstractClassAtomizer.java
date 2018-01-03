package io.annot8.pipeline.atomizers;

import io.annot8.core.data.DataItem;
import java.util.stream.Stream;

public abstract  class AbstractClassAtomizer<T extends DataItem> implements Atomizer {

  private Class<T> clazz;

  public AbstractClassAtomizer(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public boolean accepts(DataItem item) {
    return clazz.isInstance(item);
  }

  @Override
  public final Stream<DataItem> convert(DataItem item) {
    return convert((T)item);
  }

  protected abstract Stream<DataItem> convertItem(T item);
}

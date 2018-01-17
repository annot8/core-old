package io.annot8.core.helpers;

public interface Editable<T, S extends Saveable<T>> {

  S edit();
}

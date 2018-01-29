package io.annot8.core.data;

import io.annot8.core.annotations.Group;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Groups {

  Group create();

  void save(Group annotation);

  void delete(Group annotation);

  default void save(final Collection<Group> annotations) {
    annotations.forEach(this::save);
  }

  default void delete(final Collection<Group> annotations) {
    annotations.forEach(this::delete);
  }

  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  // TODO: Call this stream?!?!
  Stream<Group> getAll();

  default Stream<Group> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }
}

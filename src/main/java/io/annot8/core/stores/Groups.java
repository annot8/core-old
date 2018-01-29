package io.annot8.core.stores;

import io.annot8.core.annotations.Group;
import io.annot8.core.exceptions.IncompleteException;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Groups<A extends Group> {

    A.Builder<A> getBuilder();
    A save(A.Builder<A> groupBuilder) throws IncompleteException;


  void delete(Group annotation);

  default void delete(final Collection<Group> annotations) {
    annotations.forEach(this::delete);
  }

  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  Stream<Group> getAll();

  default Stream<Group> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

    Optional<A> getById(String groupId);

}

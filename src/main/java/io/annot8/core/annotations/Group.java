package io.annot8.core.annotations;

import io.annot8.core.data.Properties;
import io.annot8.core.exceptions.IncompleteException;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

// TODO: This needs more thought. How does it get stored? Is it linked to a specific view, or does
// it sit above them?
public interface Group extends WithId, WithType, WithProperties {
  Map<String, Stream<Annotation<?>>> getAnnotations();

  default Stream<Annotation<?>> getAnnotations(String role){
    return getAnnotations().get(role);
  }

  default Stream<String> getRoles(){
    return getAnnotations().keySet().stream();
  }

  Optional<String> getRole(Annotation<?> annotation);

  boolean containsAnnotation(Annotation<?> annotation);

  default boolean containsRole(String role) {
    return getRoles().anyMatch(role::equals);
  }

    interface Builder<A extends Group> {
        Group.Builder<A> fromGroup(A group);
        Group.Builder<A> newId();

        Group.Builder<A> addAnnotation(String role, Annotation<?> annotation);

        Group.Builder<A> setType(String type);

        Group.Builder<A> setProperty(String key, Object value);
        Group.Builder<A> setProperties(Properties properties);

        A build() throws IncompleteException;
    }
}

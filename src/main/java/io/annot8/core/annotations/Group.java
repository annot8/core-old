package io.annot8.core.annotations;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

import java.util.Collection;
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

  void addAnnotation(String role, Annotation<?> annotation);

  void removeAnnotation(Annotation<?> annotation);

  default void removeAllAnnotations(final Collection<Annotation<?>> annotations) {
    annotations.forEach(this::removeAnnotation);
  }

  boolean containsAnnotation(Annotation<?> annotation);

  default boolean containsRole(String role) {
    return getRoles().anyMatch(role::equals);
  }
}

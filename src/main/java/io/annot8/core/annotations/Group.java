package io.annot8.core.annotations;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.WithBuild;
import io.annot8.core.helpers.builders.WithFrom;
import io.annot8.core.helpers.builders.WithNewIdBuilder;
import io.annot8.core.helpers.builders.WithPropertiesBuilder;
import io.annot8.core.helpers.builders.WithTypeBuilder;

/**
 * Base annotation interface from which all other annotations extend.
 */
public interface Group extends WithId, WithType, WithProperties {
  /**
   * Return a map of all roles with the associated annotations in this group
   */
  Map<String, Stream<Annotation>> getAnnotations();

  /**
   * Return all the annotations in this group with the specified role
   */
  default Stream<Annotation> getAnnotations(final String role){
    return getAnnotations().get(role);
  }

  /**
   * Return all the roles currently associated with annotations in this group
   */
  default Stream<String> getRoles(){
    return getAnnotations().keySet().stream();
  }

  /**
   * Get the role of a specific annotation in this group
   */
  Optional<String> getRole(final Annotation annotation);

  /**
   * Returns true if this group contains the specified annotation
   */
  boolean containsAnnotation(final Annotation annotation);

  /**
   * Returns true if this group contains at least one annotation with the specified role
   */
  default boolean containsRole(final String role) {
    return getRoles().anyMatch(role::equals);
  }

  /**
   * Builder interface to create (immutable) Group classes
   */
  interface Builder<A extends Group> extends
  WithTypeBuilder<Builder<A>>,
  WithPropertiesBuilder<Builder<A>>,
  WithNewIdBuilder<Builder<A>>,
  WithFrom<Builder<A>, A>,
  WithBuild<A>
  {
    /**
     * Add an annotation to this group with the specified role
     */
    Builder<A> withAnnotation(final String role, final Annotation annotation);
  }
}

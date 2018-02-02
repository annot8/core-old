package io.annot8.core.annotations;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Base annotation interface from which all other annotations extend.
 */
public interface Group extends WithId, WithType, WithProperties {
  Map<String, Stream<Annotation<?>>> getAnnotations();

  /**
   * Return all the annotations in this group with the specified role
   */
  default Stream<Annotation<?>> getAnnotations(String role){
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
  Optional<String> getRole(Annotation<?> annotation);

  /**
   * Returns true if this group contains the specified annotation
   */
  boolean containsAnnotation(Annotation<?> annotation);

  /**
   * Returns true if this group contains at least one annotation with the specified role
   */
  default boolean containsRole(String role) {
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
        Builder<A> withAnnotation(String role, Annotation<?> annotation);
    }
}

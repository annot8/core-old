package io.annot8.core.stores;

import io.annot8.core.annotations.Group;
import io.annot8.core.exceptions.IncompleteException;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Base groups interface from which all other group stores extend.
 * 
 * @param <A>
 * 		The group supported by this store
 */
public interface GroupStore<A extends Group> {

	/**
	 * Return a builder object for the supported group
	 */
    A.Builder<A> getBuilder();
    
    /**
     * Save a group to the store from a group builder
     */
    A save(final A.Builder<A> groupBuilder) throws IncompleteException;

    /**
     * Delete a group from the store
     */
  void delete(final Group annotation);

  /**
   * Delete a collection of groups from the store
   */
  default void delete(final Collection<Group> annotations) {
    annotations.forEach(this::delete);
  }
  
  /**
   * Delete all groups from the store
   */
  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  /**
   * Get all groups currently held in this store
   */
  Stream<Group> getAll();

  /**
   * Get all groups of a given type currently held in this store
   */
  default Stream<Group> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }
  
  /**
   * Get the group with the given ID, if it is currently held in this store
   */
    Optional<A> getById(final String groupId);

}

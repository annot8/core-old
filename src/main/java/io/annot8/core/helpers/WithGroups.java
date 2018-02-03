package io.annot8.core.helpers;

import io.annot8.core.annotations.Group;
import io.annot8.core.stores.GroupStore;

/**
 * Helper interface to indicate that a class supports GroupStore
 * 
 * @param <A>
 * 		The type of group supported by this object
 */
public interface WithGroups<A extends Group> {

  /**
   * Return the groups contained within this object
   */
  GroupStore<A> getGroups();
}

package io.annot8.core.helpers;

import java.util.Optional;

public interface WithValue {

  /**
   * Get the value for this entity, if it has been set
   */
  <T> Optional<T> getValue(Class<T> clazz);

  /**
   * Set the value for this entity (use null to unset)
   */
  void setValue(Object value);
}

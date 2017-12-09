package io.annot8.core.semantic;

import io.annot8.core.helpers.WithType;
import java.util.Optional;

import io.annot8.core.annotations.Mention;
import io.annot8.core.helpers.WithMentions;
import io.annot8.core.helpers.WithProperties;

/**
 * An Entity groups together one or more {@link Mention} that refer
 * to the same physical (or conceptual) item, for example a Person.
 */
public interface Entity extends WithType, WithMentions, WithProperties {
	

	/**
	 * Set the type for this entity (use null to unset)
	 */
  void setType(String type);
	
	/**
	 * Get the value for this entity, if it has been set
	 */
  Optional<Object> getValue();
	
	/**
	 * Set the value for this entity (use null to unset)
	 */
  void setValue(Object value);
}

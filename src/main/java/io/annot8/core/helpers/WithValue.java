package io.annot8.core.helpers;

import java.util.Optional;

public interface WithValue {

	/**
	 * Get the value for this entity, if it has been set
	 */
	Optional<Object> getValue();
	default <T> Optional<T> getValue(Class<T> clazz){
		Optional<Object> val = getValue();
		
		if(!val.isPresent())
			return Optional.empty();
		
		if(clazz.isInstance(val.get())) {
			return Optional.of(clazz.cast(val.get()));
		}else {
			return Optional.empty();
		}
	}

	/**
	 * Set the value for this entity (use null to unset)
	 */
	void setValue(Object value);
}

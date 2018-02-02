package io.annot8.core.settings;

import java.lang.annotation.*;

/**
 * Declares a parameter within a settings class.
 * 
 * All parameters must have a default value of some description,
 * and therefore no parameters are required.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE) //TODO: Is this what we want the target to be?
public @interface Parameter {

	/**
	 * The configuration key associated with this parameter 
	 */
  String key();

  /**
   * A description of this parameter
   */
  String description();
}

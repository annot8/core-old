package io.annot8.core.settings;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares a parameter within a settings class.
 * 
 * This should be set on the get method for a parameter, and it
 * may generally be assumed that there is a corresponding set
 * method.
 * 
 * All parameters must have a default value of some description,
 * and therefore no parameters are required.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
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

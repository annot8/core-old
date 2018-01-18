package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// TODO: JB Is this still needed? Or can we get all the information we need directly from the
// Settings class?
// CF- I think it can go... and we can use the javadoc approach.

/**
 * Declares a configuration parameter that a component will accept/requires
 */
@Documented
@Repeatable(ConfigurationParameters.class)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface ConfigurationParameter {

  String key();

  String defaultValue();

  String description();

  boolean required() default false;
}

package io.annot8.core.settings;

import java.lang.annotation.*;

/**
 * Declares a configuration parameter that a component will accept/requires
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE) //TODO: Is this what we want the target to be?
public @interface ConfigurationParameter {

  String key();

  String defaultValue();

  String description();

  boolean required() default false;
}

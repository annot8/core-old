package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares a configuration parameter that a component will accept/requires
 */
@Documented
@Repeatable(ConfigurationParameters.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurationParameter {
	String key();
	String defaultValue();
	String description();
	boolean required() default false;
}

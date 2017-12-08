package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Repeatable(ConfigurationParameters.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurationParameter {
	String key();
	String defaultValue();
	String description();
}

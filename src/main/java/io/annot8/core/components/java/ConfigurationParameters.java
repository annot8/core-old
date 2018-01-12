package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link ConfigurationParameter} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurationParameters {

  ConfigurationParameter[] value();
}

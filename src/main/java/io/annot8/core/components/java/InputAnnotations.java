package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link InputAnnotation} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InputAnnotations {

  InputAnnotation[] value();
}

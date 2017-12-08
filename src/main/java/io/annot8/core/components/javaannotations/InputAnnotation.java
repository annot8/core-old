package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares the annotations that a processor requires
 */
@Documented
@Repeatable(InputAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface InputAnnotation {
	String value();
}

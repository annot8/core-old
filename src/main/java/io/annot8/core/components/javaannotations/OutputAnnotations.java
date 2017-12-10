package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link OutputAnnotation} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface OutputAnnotations {
	OutputAnnotation[] value();
}

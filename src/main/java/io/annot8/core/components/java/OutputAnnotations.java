package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link OutputAnnotation} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface OutputAnnotations {

  OutputAnnotation[] value();
}

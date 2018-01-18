package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link InputAnnotation} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
// TODO: CF I think this has to be configuration time thing, not a annotation at compile time

public @interface InputAnnotations {

  InputAnnotation[] value();
}

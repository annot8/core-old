package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares annotations that a processor will produce
 */
@Documented
@Repeatable(OutputAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
// TODO: CF I think this has to be configuration time thing, not a annotation at compile time
@Deprecated
public @interface OutputAnnotation {

  String value();
}

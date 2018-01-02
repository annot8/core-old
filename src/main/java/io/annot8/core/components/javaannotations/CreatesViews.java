package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares that a processor will create one or more new views,
 * and therefore should be placed at the start of a pipeline
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatesViews{

}

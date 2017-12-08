package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Repeatable(OutputAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface OutputAnnotation {
	String value();
}

package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares the content that a processor requires
 */
@Documented
@Repeatable(AcceptsContents.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptsContent {

  String value();
}

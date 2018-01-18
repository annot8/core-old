package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link AcceptsContent} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
// TODO: Terrible name
public @interface AcceptsContents {

  AcceptsContent[] value();
}

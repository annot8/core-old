package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Indicates that a component accepts content that have a given tag
 */
@Documented
@Repeatable(AcceptsTags.class)
@Retention(RetentionPolicy.RUNTIME)
// TODO: CF I think this has to be a configurable thing... so I don't think its an annotation
@Deprecated
public @interface AcceptsTag {

  String value();
}


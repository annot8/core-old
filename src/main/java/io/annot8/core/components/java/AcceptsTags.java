package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link AcceptsTag} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
// TODO: CF I think this has to be a configurable thing... so I don't think its an annotation
public @interface AcceptsTags {

  AcceptsTag[] value();
}

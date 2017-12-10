package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Container for repeated {@link AcceptsTag} annotations
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptsTags {
	AcceptsTag[] value();
}

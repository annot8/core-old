package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import io.annot8.core.data.Content;

/**
 * Declares that a processor will create one or more new content, and therefore should be placed at
 * the start of a pipeline
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatesContent {

  Class<? extends Content>[] value();
}

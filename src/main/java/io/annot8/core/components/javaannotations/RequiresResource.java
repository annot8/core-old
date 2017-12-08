package io.annot8.core.components.javaannotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.annot8.core.components.Resource;

@Documented
@Repeatable(RequiresResources.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresResource {
	Class<? extends Resource> value();
}

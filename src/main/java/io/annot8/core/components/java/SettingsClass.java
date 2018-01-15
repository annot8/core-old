package io.annot8.core.components.java;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Specify which class is to be used for settings
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SettingsClass {
    Class<?> value();
}

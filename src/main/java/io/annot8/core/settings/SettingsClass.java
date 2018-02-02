package io.annot8.core.settings;

import java.lang.annotation.*;

/**
 * Specify which class is to be used for settings
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SettingsClass {
    Class<? extends Settings> value();
}

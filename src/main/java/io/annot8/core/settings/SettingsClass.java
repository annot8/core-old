package io.annot8.core.settings;

import java.lang.annotation.*;

/**
 * Specify which class is to be used for settings by a component
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SettingsClass {
	/**
	 * The class used by this component to hold it's settings
	 */
    Class<? extends Settings> value();
}

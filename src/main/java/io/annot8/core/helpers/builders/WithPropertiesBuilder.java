package io.annot8.core.helpers.builders;

import io.annot8.core.data.Properties;

public interface WithPropertiesBuilder<A> {
    A withProperty(String key, Object value);
    A withProperties(Properties properties);
}

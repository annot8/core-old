package io.annot8.core.data;

public interface ImmutableProperties extends Properties {

    interface Builder {
        ImmutableProperties.Builder fromProperties(Properties properties);
        ImmutableProperties.Builder setProperty(String key, Object value);

        ImmutableProperties build();
    }

}

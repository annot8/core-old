package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Stream;

public interface Tags {
    default boolean has(final String tag) {
        return get().anyMatch(tag::equals);
    }
    Stream<String> get();

    interface Builder {
        Tags.Builder fromTags(Tags tags);
        Tags.Builder addTag(String tag);
        Tags.Builder addTags(Collection<String> tags);

        Tags build();
    }
}

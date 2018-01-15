package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Tags {
    default boolean has(final String tag) {
        return get().anyMatch(tag::equals);
    }

    Stream<String> get();

    default void set(final Collection<String> tags) {
        removeAll(get().collect(Collectors.toList()));
        addAll(tags);
    }

    boolean add(String tag);

    default void addAll(final Collection<String> tags) {
        tags.forEach(this::add);
    }

    boolean remove(String tag);

    default void removeAll(final Collection<String> tags) {
        tags.forEach(this::remove);
    }
}

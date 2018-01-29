package io.annot8.core.helpers.builders;

import io.annot8.core.data.Tags;

public interface WithTagsBuilder<A> {
    A withTag(String tag);
    A withTags(Tags tags);
}

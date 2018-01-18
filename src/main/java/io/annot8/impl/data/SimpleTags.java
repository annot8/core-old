package io.annot8.impl.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import io.annot8.core.data.Tags;

public class SimpleTags implements Tags {
  private final Set<String> tags;

  public SimpleTags() {
    this(Collections.emptySet());
  }

  public SimpleTags(final String... tags) {
    this(new HashSet<>(Arrays.asList(tags)));
  }

  public SimpleTags(final Set<String> tags) {
    this.tags = Collections.unmodifiableSet(tags);
  }

  @Override
  public Stream<String> stream() {
    return tags.stream();
  }

}

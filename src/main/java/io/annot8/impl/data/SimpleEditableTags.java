package io.annot8.impl.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.data.EditableTags;
import io.annot8.core.data.Tags;

public class SimpleEditableTags implements EditableTags {
  private final Set<String> tags;

  public SimpleEditableTags() {
    this(new HashSet<>());
  }

  public SimpleEditableTags(final String... tags) {
    this(new HashSet<>(Arrays.asList(tags)));
  }

  public SimpleEditableTags(final Set<String> tags) {
    this.tags = new HashSet<>(tags);
  }


  public SimpleEditableTags(final Tags tags) {
    this(tags.stream().collect(Collectors.toSet()));
  }

  @Override
  public Stream<String> stream() {
    return tags.stream();
  }

  @Override
  public boolean add(final String tag) {
    return tags.add(tag);
  }

  @Override
  public boolean remove(final String tag) {
    return tags.remove(tag);
  }
}

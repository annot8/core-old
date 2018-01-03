package io.annot8.simple;

import java.util.HashSet;
import java.util.Set;

import io.annot8.core.content.Content;
import io.annot8.core.data.View;

public class SimpleView implements View {

  private final String name;

  private final Content<?> content;

  private final Set<String> tags = new HashSet<>();

  public SimpleView(final String name, final Content<?> content) {
    this.name = name;
    this.content = content;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Content<?> getContent() {
    return content;
  }

  @Override
  public Set<String> getTags() {
    return tags;
  }

  @Override
  public boolean addTag(final String tag) {
    return tags.add(tag);
  }

  @Override
  public boolean removeTag(final String tag) {
    return tags.remove(tag);
  }
}

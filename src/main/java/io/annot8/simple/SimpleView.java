package io.annot8.simple;

import io.annot8.core.content.Content;
import io.annot8.core.data.View;
import java.util.HashSet;
import java.util.Set;

public class SimpleView implements View {

  private final String name;

  private final Content content;

  private final Set<String> tags = new HashSet<>();

  public SimpleView(String name, Content content) {
    this.name = name;
    this.content = content;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Content getContent() {
    return content;
  }

  @Override
  public Set<String> getTags() {
    return tags;
  }

  @Override
  public boolean addTag(String tag) {
    return tags.add(tag);
  }

  @Override
  public boolean removeTag(String tag) {
    return tags.remove(tag);
  }
}

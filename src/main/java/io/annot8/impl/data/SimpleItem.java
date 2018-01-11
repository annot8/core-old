package io.annot8.impl.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.content.Content;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.stores.Properties;
import io.annot8.impl.annotations.SimpleProperties;

public class SimpleItem implements Item {

  private final Map<String, Content> contents = new HashMap<>();
  private String defaultContentName = DEFAULT_CONTENT;

  private final SimpleProperties properties = new SimpleProperties();

  private static final String DEFAULT_CONTENT = "__default";

  public SimpleItem(final Content defaultContent) {
    contents.put(DEFAULT_CONTENT, defaultContent);
  }

  public SimpleItem(final Content defaultContent, final String defaultContentName) {
    contents.put(defaultContentName, defaultContent);
    this.defaultContentName = defaultContentName;
  }

  @Override
  public void setDefaultContent(final String name) {
    defaultContentName = name;
  }

  @Override
  public Content getDefaultContent() {
    return contents.get(defaultContentName);
  }

  @Override
  public Stream<String> listContents() {
    return contents.keySet().stream();
  }

  @Override
  public Optional<Content> getContent(final String name) {
    return Optional.ofNullable(contents.get(name));
  }

  @Override
  public Stream<Content> getContents() {
    return contents.values().stream();
  }

  @Override
  public <T extends Content> Stream<T> getContents(final Class<T> clazz) {
    final List<T> ret = new ArrayList<>();

    contents.values().stream().filter(c -> clazz.isAssignableFrom(c.getClass()))
        .forEach(c -> ret.add(clazz.cast(c)));

    return ret.stream();
  }

  @Override
  public void addContent(final String name, final Content content) throws AlreadyExistsException {
    if (contents.containsKey(name))
      throw new AlreadyExistsException("Content with that name already exists");

    contents.put(name, content);
  }

  @Override
  public void removeContent(final String name) {
    contents.remove(name);
  }

  @Override
  public Properties getProperties() {
    return properties;
  }
}

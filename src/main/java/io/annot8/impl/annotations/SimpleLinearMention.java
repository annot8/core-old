package io.annot8.impl.annotations;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.content.Content;

public class SimpleLinearMention implements Annotation<LinearBounds> {
  private final String id;
  private String type;

  private final Map<String, Object> properties = new HashMap<>();

  private Content<?> content;
  private LinearBounds bounds;


  public SimpleLinearMention(final Content<?> content, final LinearBounds bounds) {
    this.id = UUID.randomUUID().toString();
    this.bounds = bounds;
    this.content = content;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setType(final String type) {
    this.type = type;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setProperty(final String key, final Object value) {
    properties.put(key, value);
  }

  @Override
  public Optional<Object> removeProperty(final String key) {
    return Optional.ofNullable(properties.remove(key));
  }

  @Override
  public Map<String, Object> getProperties() {
    return properties;
  }

  @Override
  public void setContent(final Content<?> content) {
    this.content = content;
  }

  @Override
  public Content<?> getContent() {
    return content;
  }

  @Override
  public <T extends Content> Optional<T> getContent(final Class<T> clazz) {
    if (clazz.isAssignableFrom(content.getClass())) {
      return Optional.of(clazz.cast(content));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public LinearBounds getBounds() {
    return bounds;
  }

  @Override
  public void setBounds(final LinearBounds bounds) {
    this.bounds = bounds;
  }

}

package io.annot8.impl.annotations;


import java.util.UUID;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.stores.Properties;

public class SimpleLinearMention implements Annotation<LinearBounds> {
  private final String id;
  private String type;

  private LinearBounds bounds;
  private final SimpleProperties properties;

  public SimpleLinearMention(final LinearBounds bounds) {
    this.id = UUID.randomUUID().toString();
    this.bounds = bounds;
    this.properties = new SimpleProperties();
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
  public LinearBounds getBounds() {
    return bounds;
  }

  @Override
  public void setBounds(final LinearBounds bounds) {
    this.bounds = bounds;
  }

  @Override
  public Properties getProperties() {
    return properties;
  }

}

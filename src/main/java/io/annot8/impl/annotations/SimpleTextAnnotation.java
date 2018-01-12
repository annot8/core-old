package io.annot8.impl.annotations;


import java.util.UUID;
import io.annot8.content.text.TextBounds;
import io.annot8.content.text.TextAnnotation;
import io.annot8.core.stores.Properties;

public class SimpleTextAnnotation implements TextAnnotation {
  private final String id;
  private String type;

  private TextBounds bounds;
  private final SimpleProperties properties;

  public SimpleTextAnnotation(final TextBounds bounds) {
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
  public TextBounds getBounds() {
    return bounds;
  }

  @Override
  public void setBounds(final TextBounds bounds) {
    this.bounds = bounds;
  }

  @Override
  public Properties getProperties() {
    return properties;
  }

}

package io.annot8.impl.annotations;


import java.util.UUID;
import io.annot8.content.text.EditableTextAnnotation;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.core.data.Properties;
import io.annot8.impl.data.SimpleProperties;

public class SimpleTextAnnotation implements TextAnnotation {

  private final String contentName;
  private final TextBounds bounds;
  private final String id;
  private final String type;
  private final Properties properties;
  private final TextAnnotations annotations;

  public SimpleTextAnnotation(final TextAnnotations annotations, final String contentName,
      final TextBounds bounds, final String type) {
    this.annotations = annotations;
    this.contentName = contentName;
    this.bounds = bounds;
    this.id = UUID.randomUUID().toString();
    this.type = type;
    this.properties = new SimpleProperties();
  }

  public SimpleTextAnnotation(final TextAnnotations annotations,
      final EditableTextAnnotation editable) {
    this.annotations = annotations;
    this.contentName = editable.getContentName();
    this.bounds = editable.getBounds();
    this.id = editable.getId();
    this.type = editable.getType();
    // TODO: Convert to imutable
    this.properties = editable.getProperties();
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getContentName() {
    return contentName;
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
  public Properties getProperties() {
    return properties;
  }

  @Override
  public void delete() {
    annotations.delete(this);
  }

  @Override
  public EditableTextAnnotation edit() {
    return new SimpleEditableTextAnnotation(annotations, this);
  }

}

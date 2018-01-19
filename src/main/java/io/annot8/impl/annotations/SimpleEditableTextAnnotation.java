package io.annot8.impl.annotations;


import java.util.UUID;
import io.annot8.content.text.EditableTextAnnotation;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextBounds;
import io.annot8.core.data.EditableProperties;
import io.annot8.impl.data.SimpleEditableProperties;
import io.annot8.impl.stores.SimpleTextAnnotations;

public class SimpleEditableTextAnnotation implements EditableTextAnnotation {
  private final String contentName;
  private final String id;
  private final SimpleTextAnnotations annotations;

  private String type;

  private TextBounds bounds;
  private final EditableProperties properties;

  public SimpleEditableTextAnnotation(final SimpleTextAnnotations annotations, final String contentName,
      final TextBounds bounds) {
    this.annotations = annotations;
    this.contentName = contentName;
    this.id = UUID.randomUUID().toString();
    this.bounds = bounds;
    this.properties = new SimpleEditableProperties();
  }

  public SimpleEditableTextAnnotation(final SimpleTextAnnotations annotations,
      final TextAnnotation annotation) {
    this.annotations = annotations;
    this.contentName = annotation.getContentName();
    this.id = annotation.getId();
    this.bounds = annotation.getBounds();
    this.properties = new SimpleEditableProperties(annotation.getProperties());
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
  public EditableProperties getProperties() {
    return properties;
  }

  @Override
  public TextAnnotation save() {
    return annotations.save(this);
  }

  @Override
  public void delete() {
    annotations.delete(this);
  }

}

package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.data.OverlayProperties;
import io.annot8.core.data.Properties;

// TODO: CF I'm not sure that Annotation and AnnotationOver
public abstract class Overlay implements Annotatable {

  private final Annotation annotation;
  private final OverlayProperties properties;

  public Overlay(final Annotation annotation) {
    this.annotation = annotation;
    this.properties = new OverlayProperties(annotation.getProperties());
    postConstruct();
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  protected void postConstruct() {
    // Do nothing - implement if required
  }

  protected void preSave() {
    // Do nothing - implement if required
  }

  @Override
  public void save() {
    preSave();
    annotation.save();
  }

  @Override
  public void delete() {
    annotation.delete();
  }

  public boolean validate() {
    // Do nothing - implement if required
    return true;
  }

  // Proxy annotation interface methods to the underlying annotation

  @Override
  public String getId() {
    return getAnnotation().getType();
  }

  @Override
  public String getType() {
    return getAnnotation().getType();
  }

  @Override
  public Bounds getBounds() {
    return getAnnotation().getBounds();
  }

  @Override
  public void setBounds(final Bounds bounds) {
    getAnnotation().setBounds(bounds);
  }

  @Override
  public Properties getProperties() {
    return this.properties;
  }


}

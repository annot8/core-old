package io.annot8.core.annotations;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.bounds.Bounds;

// TODO: CF I'm not sure that Annotation and AnnotationOver
public abstract class Overlay implements Annotatable {

  private final Annotation annotation;

  public Overlay(Annotation annotation) {
    this.annotation = annotation;
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
  public void setBounds(Bounds bounds) {
    getAnnotation().setBounds(bounds);
  }

  @Override
  public boolean hasProperty(String key) {
    return getAnnotation().hasProperty(key);
  }

  @Override
  public Optional<Object> getProperty(String key) {
    return getAnnotation().getProperty(key);
  }

  @Override
  public Object getPropertyOrDefault(String key, Object defaultValue) {
    return getAnnotation().getPropertyOrDefault(key, defaultValue);
  }

  @Override
  public void setProperty(String key, Object value) {
    getAnnotation().setProperty(key, value);
  }

  @Override
  public Optional<Object> removeProperty(String key) {
    return getAnnotation().removeProperty(key);
  }

  @Override
  public Stream<String> listPropertyKeys() {
    return getAnnotation().listPropertyKeys();
  }

  @Override
  public Map<String, Object> getProperties() {
    return getAnnotation().getProperties();
  }

  @Override
  public void setProperties(Map<String, Object> properties) {
    getAnnotation().setProperties(properties);
  }

  @Override
  public void clear() {
    getAnnotation().clear();
  }

  @Override
  public void addProperties(Map<String, Object> properties) {
    getAnnotation().addProperties(properties);
  }

  @Override
  public void removeProperties(Collection<String> keys) {
    getAnnotation().removeProperties(keys);
  }


}

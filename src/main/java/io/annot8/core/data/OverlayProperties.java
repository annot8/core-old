package io.annot8.core.data;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class OverlayProperties implements Properties {

  private final Properties properties;

  public OverlayProperties(final Properties properties) {
    this.properties = properties;
  }


  @Override
  public boolean hasProperty(final String key) {
    return properties.hasProperty(key);
  }

  @Override
  public Optional<Object> getProperty(final String key) {
    return properties.getProperty(key);
  }

  @Override
  public Object getPropertyOrDefault(final String key, final Object defaultValue) {
    return properties.getPropertyOrDefault(key, defaultValue);
  }

  @Override
  public void setProperty(final String key, final Object value) {
    properties.setProperty(key, value);
  }

  @Override
  public Optional<Object> removeProperty(final String key) {
    return properties.removeProperty(key);
  }

  @Override
  public Stream<String> listPropertyKeys() {
    return properties.listPropertyKeys();
  }

  @Override
  public Map<String, Object> getProperties() {
    return properties.getProperties();
  }

  @Override
  public void setProperties(final Map<String, Object> map) {
    properties.setProperties(map);
  }

  @Override
  public void clear() {
    properties.clear();
  }

  @Override
  public void addProperties(final Map<String, Object> map) {
    properties.addProperties(map);
  }

  @Override
  public void removeProperties(final Collection<String> keys) {
    properties.removeProperties(keys);
  }

}

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
  public boolean has(final String key) {
    return properties.has(key);
  }

  @Override
  public Optional<Object> get(final String key) {
    return properties.get(key);
  }

  @Override
  public Object getOrDefault(final String key, final Object defaultValue) {
    return properties.getOrDefault(key, defaultValue);
  }

  @Override
  public void set(final String key, final Object value) {
    properties.set(key, value);
  }

  @Override
  public Optional<Object> remove(final String key) {
    return properties.remove(key);
  }

  @Override
  public Stream<String> getKeys() {
    return properties.getKeys();
  }

  @Override
  public Map<String, Object> getAll() {
    return properties.getAll();
  }

  @Override
  public void set(final Map<String, Object> map) {
    properties.set(map);
  }

  @Override
  public void clear() {
    properties.clear();
  }

  @Override
  public void add(final Map<String, Object> map) {
    properties.add(map);
  }

  @Override
  public void remove(final Collection<String> keys) {
    properties.remove(keys);
  }

}

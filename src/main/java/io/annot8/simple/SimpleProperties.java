package io.annot8.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import io.annot8.core.helpers.WithProperties;

public class SimpleProperties implements WithProperties {

  private final Map<String, Object> map = new HashMap<>();

  @Override
  public void setProperty(String key, Object value) {
    map.put(key, value);
  }

  @Override
  public Optional<Object> removeProperty(String key) {
    return Optional.ofNullable(map.remove(key));
  }

  @Override
  public Map<String, Object> getProperties() {
    return map;
  }

}

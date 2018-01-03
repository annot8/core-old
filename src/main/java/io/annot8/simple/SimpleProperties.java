package io.annot8.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import io.annot8.core.data.Properties;

public class SimpleProperties implements Properties {

  private final Map<String, Object> map = new HashMap<>();

  @Override
  public void set(final String key, final Object value) {
    map.put(key, value);
  }

  @Override
  public Optional<Object> remove(final String key) {
    return Optional.ofNullable(map.remove(key));
  }

  @Override
  public Map<String, Object> getAll() {
    return map;
  }

}

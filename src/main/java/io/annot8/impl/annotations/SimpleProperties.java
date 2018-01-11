package io.annot8.impl.annotations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import io.annot8.core.stores.Properties;

public class SimpleProperties implements Properties {
  private final Map<String, Object> properties = new HashMap<>();

  @Override
  public void setProperty(final String key, final Object value) {
    properties.put(key, value);
  }

  @Override
  public Optional<Object> removeProperty(final String key) {
    return Optional.ofNullable(properties.remove(key));
  }

  @Override
  public Map<String, Object> getProperties() {
    return properties;
  }

}

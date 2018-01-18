package io.annot8.impl.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import io.annot8.core.data.EditableProperties;
import io.annot8.core.data.Properties;

public class SimpleEditableProperties implements EditableProperties {
  private final Map<String, Object> properties;

  public SimpleEditableProperties() {
    this.properties = new HashMap<>();
  }

  public SimpleEditableProperties(final Properties properties) {
    this.properties = new HashMap<>(properties.getAll());
  }

  @Override
  public void set(final String key, final Object value) {
    properties.put(key, value);
  }

  @Override
  public Optional<Object> remove(final String key) {
    return Optional.ofNullable(properties.remove(key));
  }

  @Override
  public Map<String, Object> getAll() {
    return properties;
  }


}

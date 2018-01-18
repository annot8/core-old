package io.annot8.impl.data;

import java.util.Collections;
import java.util.Map;
import io.annot8.core.data.Properties;

public class SimpleProperties implements Properties {
  private final Map<String, Object> properties;

  public SimpleProperties() {
    this.properties = Collections.emptyMap();
  }

  public SimpleProperties(final Properties properties) {
    this.properties = Collections.unmodifiableMap(properties.getAll());
  }


  @Override
  public Map<String, Object> getAll() {
    return properties;
  }


}

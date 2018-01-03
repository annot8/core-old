package io.annot8.simple;

import java.util.Map;

import io.annot8.core.components.Resource;
import io.annot8.core.context.ConfiguringContext;

public class SimpleConfiguringContext extends SimpleContext implements ConfiguringContext {

  public SimpleConfiguringContext(Map<String, Object> configuration,
      Map<String, Resource> resources) {
    super(configuration, resources);
  }
}

package io.annot8.simple;

import java.util.Map;

import io.annot8.core.components.Resource;
import io.annot8.core.context.ProcessingContext;

public class SimpleProcessingContext extends SimpleContext implements ProcessingContext {

  public SimpleProcessingContext(Map<String, Object> configuration,
      Map<String, Resource> resources) {
    super(configuration, resources);
  }

}

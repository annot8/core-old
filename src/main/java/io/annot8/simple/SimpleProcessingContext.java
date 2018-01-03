package io.annot8.simple;

import io.annot8.core.components.Resource;
import io.annot8.core.context.ProcessingContext;
import java.util.Map;

public class SimpleProcessingContext extends SimpleContext implements ProcessingContext {

  public SimpleProcessingContext(Map<String, Object> configuration,
      Map<String, Resource> resources) {
    super(configuration, resources);
  }

}

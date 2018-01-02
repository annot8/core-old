package simple;

import io.annot8.core.components.Resource;
import io.annot8.core.context.ConfiguringContext;
import java.util.Map;

public class SimpleConfiguringContext extends SimpleContext implements ConfiguringContext {

  public SimpleConfiguringContext(Map<String, Object> configuration,
      Map<String, Resource> resources) {
    super(configuration, resources);
  }
}

package simple;

import io.annot8.core.components.Resource;
import io.annot8.core.context.Context;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleContext implements Context {

  private final Map<String, Object> configuration;

  private final Map<String, Resource> resources;

  protected SimpleContext(Map<String, Object> configuration,
      Map<String, Resource> resources) {
    this.configuration = configuration;
    this.resources = resources;
  }

  protected Map<String, Object> getRawConfiguration() {
    return configuration;
  }

  protected Map<String, Resource> getRawResources() {
    return resources;
  }

  public <T extends Resource> Stream<T> getResources(Class<T> clazz) {
    return resources.values().stream().filter(clazz::isInstance).map(clazz::cast);
  }

  @Override
  public Optional<Object> getConfiguration(String key) {
    return Optional.ofNullable(configuration.get(key));
  }


  @SuppressWarnings("unchecked")
  @Override
  public <T extends Resource> Optional<T> getResource(String key, Class<T> clazz) {
    Resource r = resources.get(key);
    if (r != null && clazz.isInstance(r)) {
      return Optional.of((T) r);
    }

    return Optional.empty();
  }


}

package io.annot8.impl.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.components.Resource;

public class SimpleGlobalContext {
  private final Map<Class<? extends Resource>, Map<String, Resource>> resources = new HashMap<>();

  public void addResource(final String key, final Resource resource) {
    final Map<String, Resource> classResources =
        resources.getOrDefault(resource.getClass(), new HashMap<>());
    classResources.put(key, resource);
    resources.put(resource.getClass(), classResources);
  }

  public <T extends Resource> Optional<T> getResource(final String key, final Class<T> clazz) {
    final Map<String, Resource> classResources =
        resources.getOrDefault(clazz, Collections.emptyMap());
    return Optional.ofNullable(clazz.cast(classResources.get(key)));
  }

  public <T extends Resource> Stream<T> getResources(final Class<T> clazz) {
    final List<T> ret = new ArrayList<>();

    for (final Resource r : resources.get(clazz).values())
      ret.add(clazz.cast(r));

    return ret.stream();
  }

  public Stream<String> listResourceKeys() {
    return resources.values().stream().flatMap(m -> m.keySet().stream()).distinct();
  }
}

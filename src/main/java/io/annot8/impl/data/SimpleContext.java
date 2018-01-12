package io.annot8.impl.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.components.Resource;
import io.annot8.core.data.Context;

public class SimpleContext implements Context {
  private final Map<Class<? extends Resource>, Map<String, Resource>> resources = new HashMap<>();
  private final Map<String, Object> configuration = new HashMap<>();

  public void addConfiguration(final String key, final Object value) {
    configuration.put(key, value);
  }

  public void addResource(final String key, final Resource resource) {
    final Map<String, Resource> classResources =
        resources.getOrDefault(resource.getClass(), new HashMap<>());
    classResources.put(key, resource);
    resources.put(resource.getClass(), classResources);
  }

  @Override
  public Optional<Object> getConfiguration(final String key) {
    return Optional.ofNullable(configuration.get(key));
  }

  @Override
  public <T extends Resource> Optional<T> getResource(final String key, final Class<T> clazz) {
    final Map<String, Resource> classResources =
        resources.getOrDefault(clazz, Collections.emptyMap());
    return Optional.ofNullable(clazz.cast(classResources.get(key)));
  }

  @Override
  public <T extends Resource> Stream<T> getResources(final Class<T> clazz) {
    final List<T> ret = new ArrayList<>();

    for (final Resource r : resources.get(clazz).values())
      ret.add(clazz.cast(r));

    return ret.stream();
  }
}

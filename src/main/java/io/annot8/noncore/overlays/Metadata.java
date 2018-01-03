package io.annot8.noncore.overlays;

import java.util.Optional;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.Overlay;
import io.annot8.core.helpers.WithValue;

/**
 * Annotation to hold document level metadata that has no location within the text. For example, a
 * document author or creation date.
 */
public class Metadata extends Overlay implements WithValue {

  public static final String TYPE = "metadata";
  public static final String KEY_PROPERTY = "key";
  public static final String VALUE_PROPERTY = "value";

  public Metadata(final Annotation annotation) {
    super(annotation);
  }

  /**
   * Get the key for this annotation
   */
  public String getKey() {
    return (String) getProperties().getOrDefault(KEY_PROPERTY, "");
  }

  /**
   * Set the key for this annotation
   */
  void setKey(final String key) {
    getProperties().set(KEY_PROPERTY, key);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> getValue(final Class<T> clazz) {
    // TODO:CF I think this logic should be part of WithProperties.. not implemented repeated
    final Optional<Object> optional = getProperties().get(VALUE_PROPERTY);

    if (optional.isPresent()) {
      final Object v = optional.get();
      if (clazz.isInstance(v)) {
        return Optional.of((T) v);
      }
    }

    return Optional.empty();
  }

  @Override
  public void setValue(final Object value) {
    getProperties().set(VALUE_PROPERTY, value);
  }
}

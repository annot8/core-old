package io.annot8.noncore.overlays;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.Overlay;
import io.annot8.core.helpers.WithValue;
import java.util.Optional;

/**
 * Annotation to hold document level metadata that has no location within the text. For example, a
 * document author or creation date.
 */
public class Metadata extends Overlay implements WithValue {

  public static final String TYPE = "metadata";
  public static final String KEY_PROPERTY = "key";
  public static final String VALUE_PROPERTY = "value";

  public Metadata(Annotation annotation) {
    super(annotation);
  }
  /**
   * Get the key for this annotation
   */
  public String getKey() {
    return (String) getPropertyOrDefault(KEY_PROPERTY, "");
  }

  /**
   * Set the key for this annotation
   */
  void setKey(String key) {
    setProperty(KEY_PROPERTY, key);
  }

  @Override
  public <T> Optional<T> getValue(Class<T> clazz) {
    // TODO:CF I think this logic should be part of WithProperties.. not implemented repeated
    Optional<Object> optional = getProperty(VALUE_PROPERTY);

    if (optional.isPresent()) {
      if (clazz.isInstance(optional.get())) {
        return Optional.of((T) (optional.get()));
      }
    }

    return Optional.empty();
  }

  @Override
  public void setValue(Object value) {
    setProperty(VALUE_PROPERTY, value);
  }
}

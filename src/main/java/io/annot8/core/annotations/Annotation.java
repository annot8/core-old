package io.annot8.core.annotations;


import java.util.Optional;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.content.Content;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

/**
 * Base annotation interface from which all other annotations extend.
 *
 * This class provides the common functionality required to track the history of an annotation (i.e.
 * which processor created it, which ones modified it, etc.)
 */
public interface Annotation<T extends Bounds> extends WithId, WithType, WithProperties {
  T getBounds();

  void setBounds(T bounds);

  void setContent(Content<?> content);

  Content<?> getContent();

  <T extends Content> Optional<T> getContent(Class<T> clazz);
}

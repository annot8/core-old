package io.annot8.content.text;

import java.util.Optional;
import io.annot8.core.data.TypedContent;
import io.annot8.core.stores.Annotations;

/**
 * Documents store the text to be processed, and may also contain links to sub-content (known as
 * views) which contain different versions of the same content (for example, a translated version).
 *
 * Documents can contain no content and just sub-content, although this is expected to be an unusual
 * use case.
 */
public interface Text
    extends TypedContent<TextBounds, TextAnnotation, Annotations<TextBounds, TextAnnotation>, String> {

  Optional<String> getLanguage();

  void setLanguage(String language);

  // TODO: Should this be on Content generically
  String getText(TextBounds lb);

}

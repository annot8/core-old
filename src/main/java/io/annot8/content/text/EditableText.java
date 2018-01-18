package io.annot8.content.text;

import java.util.Optional;
import io.annot8.core.data.EditableTypedContent;

/**
 * Documents store the text to be processed, and may also contain links to sub-content (known as
 * views) which contain different versions of the same content (for example, a translated version).
 *
 * Documents can contain no content and just sub-content, although this is expected to be an unusual
 * use case.
 */
public interface EditableText extends
    EditableTypedContent<TextBounds, TextAnnotation, EditableTextAnnotation, TextAnnotations, String> {

  Optional<String> getLanguage();

  void setLanguage(String language);

  // TODO: Should this be on Content generically
  String getText(TextBounds lb);

}

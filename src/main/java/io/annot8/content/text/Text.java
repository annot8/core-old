package io.annot8.content.text;

import java.util.Optional;
import io.annot8.core.data.TypedContent;

/**
 * Documents store the text to be processed, and may also contain links to sub-content (known as
 * views) which contain different versions of the same content (for example, a translated version).
 *
 * Documents can contain no content and just sub-content, although this is expected to be an unusual
 * use case.
 */
public interface Text extends
    TypedContent<TextBounds, TextAnnotation, EditableTextAnnotation, TextAnnotations, String> {

  // TODO: I think this should be 'UNKNOWN" rather than null...
  Optional<String> getLanguage();

  // TODO: Should this be on Content generically
  String getText(TextBounds lb);

  @Override
  EditableText edit();
}

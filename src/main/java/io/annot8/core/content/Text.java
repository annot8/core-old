package io.annot8.core.content;

import java.util.Optional;

/**
 * Documents store the text to be processed, and may also contain links to sub-content (known as
 * views) which contain different versions of the same content (for example, a translated version).
 *
 * Documents can contain no content and just sub-content, although this is expected to be an unusual
 * use case.
 */
public interface Text extends Content<String> {

  Optional<String> getLanguage();

  void setLanguage(String language);

}

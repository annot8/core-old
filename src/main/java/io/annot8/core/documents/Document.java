package io.annot8.core.documents;

import java.util.Optional;

/**
 * Documents store the text to be processed, and may also contain links
 * to sub-documents (known as views) which contain different versions of
 * the same content (for example, a translated version).
 * 
 * Documents can contain no content and just sub-documents, although this
 * is expected to be an unusual use case.
 */
public interface Document extends Content<String> {

	Optional<String> getLanguage();
	void setLanguage(String language);

}

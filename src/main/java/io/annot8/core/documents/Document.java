package io.annot8.core.documents;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import io.annot8.core.exceptions.UnmodifiableDocumentException;

/**
 * Documents store the text to be processed, and may also contain links
 * to sub-documents (known as views) which contain different versions of
 * the same content (for example, a translated version).
 * 
 * Documents can contain no content and just sub-documents, although this
 * is expected to be an unusual use case.
 */
public interface Document {
	Optional<String> getContent();
	void setContent(String content) throws UnmodifiableDocumentException;
	boolean canModifyContent();
	
	Optional<String> getLanguage();
	void setLanguage(String language);
	
	boolean hasView(String name);
	Set<String> listViews();
	Optional<Document> getView(String name);
	void setView(String name, Document view);
	Optional<Document> removeView(String name);
	
	boolean hasTag(String tag);
	Set<String> getTags();
	void setTags(Set<String> tags);
	boolean addTag(String tag);
	void addAllTags(Collection<String> tags);
	boolean removeTag(String tag);
	void removeAllTags(Collection<String> tags);
}

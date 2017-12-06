package io.annot8.core.documents;

import java.util.Collection;
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
	public static final String LANGUAGE_UNKNOWN = "x-unknown";
	
	public boolean hasContent();
	public String getContent();
	public boolean canModifyContent();
	public void setContent(String content) throws UnmodifiableDocumentException;
	
	public String getLanguage();
	public void setLanguage(String language);
	
	public boolean hasView(String name);
	public Set<String> listViews();
	public Document getView(String name);
	public void setView(String name, Document view);
	public Document removeView(String name);
	
	public boolean hasTag(String tag);
	public Set<String> getTags();
	public void setTags(Set<String> tags);
	public boolean addTag(String tag);
	public void addAllTags(Collection<String> tags);
	public boolean removeTag(String tag);
	public void removeAllTags(Collection<String> tags);
}

package io.annot8.core.documents;

import java.util.Set;

import io.annot8.core.exceptions.UnmodifiableDocumentException;

public interface Document {
	public boolean hasContent();
	public String getContent();
	public void setContent(String content) throws UnmodifiableDocumentException;
	
	public boolean hasView(String name);
	public Set<String> listViews();
	public Document getView(String name);
	public void setView(String name, Document view);
	public Document removeView(String name);
}

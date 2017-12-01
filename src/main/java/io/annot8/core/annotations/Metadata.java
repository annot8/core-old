package io.annot8.core.annotations;

/**
 * Annotation to hold document level metadata that has no
 * location within the text. For example, a document author
 * or creation date.
 */
public interface Metadata extends Annotation{
	public String getKey();
	public void setKey(String key);
	
	public Object getValue();
	public void setValue(Object value);
}

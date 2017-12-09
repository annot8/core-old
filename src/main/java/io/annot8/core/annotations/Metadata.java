package io.annot8.core.annotations;

/**
 * Annotation to hold document level metadata that has no
 * location within the text. For example, a document author
 * or creation date.
 */
public interface Metadata extends Annotation{
	
	/**
	 * Get the key for this annotation
	 */
	public String getKey();
	
	/**
	 * Set the key for this annotation
	 */
	public void setKey(String key);
	
	/**
	 * Get the value for this annotation
	 */
	public Object getValue();
	
	/**
	 * Set the value for this annotation
	 */
	public void setValue(Object value);
}

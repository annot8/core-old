package io.annot8.core.annotations;

public interface Metadata extends Annotation{
	public String getKey();
	public void setKey(String key);
	
	public Object getValue();
	public void setValue(Object value);
}

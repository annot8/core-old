package io.annot8.core.helpers;

public interface WithType {

	void setType(String type);
	
  /**
   * Return the type, if it has been set.
   */
  String getType();
}

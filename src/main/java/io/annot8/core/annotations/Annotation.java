package io.annot8.core.annotations;


/**
 * Base annotation interface from which all other annotations extend.
 * 
 * This class provides the common functionality required to track the
 * history of an annotation (i.e. which processor created it, which
 * ones modified it, etc.)
 */
public interface Annotation {
	
	/**
	 * Return the ID assigned to this annotation
	 */
	String getId();

	/**
	 * Return the Annotation type, if it has been set
	 */
	default String getType() {
		return this.getClass().getSimpleName();
	}

}

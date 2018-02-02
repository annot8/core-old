package io.annot8.core.data;

import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithTags;
import io.annot8.core.helpers.builders.*;
import io.annot8.core.stores.Annotations;

/**
 * Base content interface from which all content implementations extend.
 */
public interface Content<D> extends WithTags, WithProperties {

	/**
	 *  Return the data associated with this content object
	 */
  D getData();

  /**
   * Return the annotation store for this content
   */
  Annotations<?, ?> getAnnotations();

  /**
   * Return the name of this content
   */
  String getName();

	/**
	 * Builder interface to create (immutable) Content classes
	 */
  interface Builder<A extends Content<D>, D> extends
          WithPropertiesBuilder<Builder<A, D>>,
          WithTagsBuilder<Builder<A, D>>,
          WithFrom<Builder<A, D>, A>,
          WithBuild<A>
  {
	/**
	 * Set the name of this content object
	 */
	  Content.Builder<A, D> withName(String name);
	  
	/**
	 * Set the data for this content object
	 */
    Content.Builder<A, D> withData(D content);
    
    /**
	 * Set the annotation store for this content object
	 */
    Content.Builder<A, D> withAnnotations(Annotations<?, ?> annotations);
  }
}
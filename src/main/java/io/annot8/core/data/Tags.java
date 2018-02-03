package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Stream;

import io.annot8.core.helpers.builders.WithBuild;
import io.annot8.core.helpers.builders.WithFrom;

/**
 * Base tags interface from which all tags implementations extend.
 */
public interface Tags {
	/**
	 * Return true if this object contains the specified tag
	 */
    default boolean has(final String tag) {
        return get().anyMatch(tag::equals);
    }
    
    /**
     * Return all the tags current held in this object
     */
    Stream<String> get();

	/**
	 * Builder interface to create (immutable) Tags classes
	 */
    interface Builder extends 
    		WithFrom<Builder, Tags>, 
    		WithBuild<Tags>
    {

        /**
         * Add a tag to this tags object
         */
        Builder addTag(final String tag);
        
        /**
         * Add a collection of tags to this tags object
         */
        Builder addTags(final Collection<String> tags);

    }
}

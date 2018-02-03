package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.*;

/**
 * Base annotation interface from which all other annotations extend.
 */
public interface Annotation<B extends Bounds> extends WithId, WithType, WithProperties {
	/**
	 * Get the {@link Bounds} associated with this annotation
	 */
	B getBounds();

	/**
	 * Get the name of the Content to which this annotation refers
	 */
	String getContentName();

	/**
	 * Builder interface to create (immutable) Annotation classes
	 */
	interface Builder<A extends Annotation<B>, B extends Bounds> extends
            WithTypeBuilder<Builder<A, B>>,
            WithPropertiesBuilder<Builder<A, B>>,
            WithNewIdBuilder<Builder<A, B>>,
            WithFrom<Builder<A, B>, A>,
            WithBuild<A>
    {
		/**
		 * Set the name of the Content to which this annotation refers
		 */
		Builder<A, B> withContent(final String contentName);
		
		/**
		 * Set the {@link Bounds} associated with this annotation
		 */
		Builder<A, B> withBounds(final B bounds);
	}
}

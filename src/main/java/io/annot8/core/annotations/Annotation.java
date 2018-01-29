package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.*;

/**
 * Base annotation interface from which all other annotations extend.
 *
 * This class provides the common functionality required to track the history of an annotation (i.e.
 * which processor created it, which ones modified it, etc.)
 */
public interface Annotation<B extends Bounds> extends WithId, WithType, WithProperties {
	B getBounds();

	// The content against which this annotation was created
	String getContentName();

	interface Builder<A extends Annotation<B>, B extends Bounds> extends
            WithTypeBuilder<Builder<A, B>>,
            WithPropertiesBuilder<Builder<A, B>>,
            WithNewIdBuilder<Builder<A, B>>,
            WithFrom<Builder<A, B>, A>,
            WithBuild<A>
    {
		Builder<A, B> withContent(String contentName);
		Builder<A, B> withBounds(B bounds);
	}
}

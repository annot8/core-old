package io.annot8.core.annotations;


import io.annot8.core.helpers.WithBounds;
import io.annot8.core.helpers.WithDelete;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithSave;
import io.annot8.core.helpers.WithType;

/**
 * Base annotation interface from which all other annotations extend.
 *
 * This class provides the common functionality required to track the history of an annotation (i.e.
 * which processor created it, which ones modified it, etc.)
 */
public interface Annotatable extends WithId, WithType, WithBounds,
    WithProperties, WithSave, WithDelete {

}
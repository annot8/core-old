package io.annot8.noncore.overlays;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.IntLineBounds;
import io.annot8.core.helpers.WithProperties;
import io.annot8.noncore.helpers.WithTextBounds;
import io.annot8.noncore.semantic.Association;

/**
 * Annotation to hold information about a specific part of the document text, for instance a noun
 * phrase or individual word token.
 *
 * Mentions of an {@link io.annot8.noncore.semantic.Entity} or {@link Association}
 * should be referenced with the {@link Mention} class, rather than this one.
 */
public interface TextSpan extends Annotation<IntLineBounds>, WithProperties, WithTextBounds {


}

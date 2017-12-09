package io.annot8.core.annotations;

import io.annot8.core.annotations.bounds.IntegerLineBound;
import java.util.Optional;

import io.annot8.core.helpers.WithProperties;

/**
 * Annotation to hold information about a specific part of the
 * document text, for instance a noun phrase or individual word
 * token.
 * 
 * Mentions of an {@link io.annot8.core.semantic.Entity} or
 * {@link io.annot8.core.semantic.Relation} should be referenced with
 * the {@link Mention} class, rather than this one.
 */
public interface Span extends Annotation, WithProperties, IntegerLineBound {

	

}

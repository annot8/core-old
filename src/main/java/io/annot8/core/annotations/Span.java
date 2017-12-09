package io.annot8.core.annotations;

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
public interface Span extends Annotation, WithProperties {
	
	/**
	 * Return the Span type, if it has been set
	 */
	public Optional<String> getType();
	
	/**
	 * Set the Span type (use null to unset)
	 */
	public void setType(String type);
	
	/**
	 * Return the begin offset
	 */
	public int getBegin();
	
	/**
	 * Set the begin offset
	 */
	public void setBegin(int begin);
	
	/**
	 * Return the end offset
	 */
	public int getEnd();
	
	/**
	 * Set the end offset
	 */
	public void setEnd(int end);
}

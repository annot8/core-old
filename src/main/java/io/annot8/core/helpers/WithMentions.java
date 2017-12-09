package io.annot8.core.helpers;

import java.util.Collection;
import java.util.Set;

import io.annot8.core.annotations.Mention;

/**
 * Indicates that an object stores a collection of {@link Mention} objects.
 * 
 * Helper interface to reduce duplicate code.
 */
public interface WithMentions {
	void addMention(Mention mention);
	boolean removeMention(Mention mention);
	Set<Mention> getMentions();
	default void setMentions(Set<Mention> mentions) {
		removeMentions(getMentions());
		addMentions(mentions);
	}
	default void addMentions(Collection<Mention> mentions) {
		mentions.forEach(this::addMention);
	}
	default void removeMentions(Collection<Mention> mentions) {
		mentions.forEach(this::removeMention);
	}
}

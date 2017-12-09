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
	void setMentions(Set<Mention> mentions);
	void addMentions(Collection<Mention> mentions);
	void removeMentions(Collection<Mention> mentions);
}

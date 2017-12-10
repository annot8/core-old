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
	public void addMention(Mention mention);
	public boolean removeMention(Mention mention);
	public Set<Mention> getMentions();
	public void setMentions(Set<Mention> mentions);
	public void addMentions(Collection<Mention> mentions);
	public void removeMentions(Collection<Mention> mentions);
}

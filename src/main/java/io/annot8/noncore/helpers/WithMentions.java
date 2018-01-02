package io.annot8.noncore.helpers;

import io.annot8.noncore.overlays.Mention;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Indicates that an object stores a collection of {@link Mention} objects.
 *
 * Helper interface to reduce duplicate code.
 */
public interface WithMentions {

  void addMention(Mention mention);

  boolean removeMention(Mention mention);

  Stream<Mention> getMentions();

  default void setMentions(Collection<Mention> mentions) {
    removeMentions(getMentions().collect(Collectors.toList()));
    addMentions(mentions);
  }

  default void addMentions(Collection<Mention> mentions) {
    mentions.forEach(this::addMention);
  }

  default void removeMentions(Collection<Mention> mentions) {
    mentions.forEach(this::removeMention);
  }
}

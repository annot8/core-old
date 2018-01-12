package io.annot8.impl.data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;

public class SimpleText implements Text {

  private String language = null;
  private final String content;

  private final Set<String> tags = new HashSet<>();

  public SimpleText(final String content) {
    this.content = content;
  }

  @Override
  public TextAnnotations getAnnotations() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<String> getLanguage() {
    return Optional.ofNullable(language);
  }

  @Override
  public void setLanguage(final String language) {
    this.language = language;
  }

  @Override
  public String getData() {
    return content;
  }

  @Override
  public Stream<String> getTags() {
    return tags.stream();
  }

  @Override
  public boolean addTag(final String tag) {
    return tags.add(tag);
  }

  @Override
  public boolean removeTag(final String tag) {
    return tags.remove(tag);
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof SimpleText))
      return false;

    final SimpleText st = (SimpleText) obj;

    return Objects.equals(getData(), st.getData())
        && Objects.equals(getLanguage(), st.getLanguage())
        && Objects.equals(getTags(), st.getTags());
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, language);
  }

  @Override
  public String getText(final TextBounds lb) {
    if (lb != null && lb.getBegin() >= 0 && lb.getEnd() >= 0 && lb.getBegin() >= lb.getEnd()) {
      return content.substring(lb.getBegin(), lb.getEnd());
    } else {
      return "";
    }
  }
}

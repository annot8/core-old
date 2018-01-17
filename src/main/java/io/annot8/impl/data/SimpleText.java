package io.annot8.impl.data;

import java.util.Objects;
import java.util.Optional;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.core.data.Tags;

public class SimpleText implements Text {

  private String language = null;
  private final String name;
  private final String content;

  private final Tags tags = new SimpleTags();
  private final TextAnnotations annotations;

  public SimpleText(final String name, final String content, final TextAnnotations annotations) {
    this.name = name;
    this.content = content;
    this.annotations = annotations;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public TextAnnotations getAnnotations() {
    return annotations;
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

  @Override
  public Tags getTags() {
    return tags;
  }
}

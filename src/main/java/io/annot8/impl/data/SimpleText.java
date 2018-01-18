package io.annot8.impl.data;

import java.util.Objects;
import java.util.Optional;
import io.annot8.content.text.EditableText;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.core.data.Properties;
import io.annot8.core.data.Tags;

public class SimpleText implements Text {

  private final String language;
  private final String name;
  private final String content;

  private final Tags tags;
  private final Properties properties;
  private final TextAnnotations annotations;

  public SimpleText(final String name, final String content, final TextAnnotations annotations) {
    this.name = name;
    this.content = content;
    this.annotations = annotations;
    this.language = null;
    this.tags = new SimpleTags();
    this.properties = new SimpleProperties();
  }

  public SimpleText(final String content, final TextAnnotations annotations,
      final EditableText editableText) {
    this.content = content;
    this.annotations = annotations;
    this.name = editableText.getName();
    this.language = editableText.getLanguage().orElse(null);
    this.tags = new SimpleTags(editableText.getTags());

    // TODO: Immutable
    this.properties = editableText.getProperties();
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

  @Override
  public Properties getProperties() {
    return properties;
  }

  @Override
  public EditableText edit() {
    return new SimpleEditableText(annotations, content, this);
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub

  }


}

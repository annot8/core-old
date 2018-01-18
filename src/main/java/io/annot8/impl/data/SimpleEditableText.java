package io.annot8.impl.data;

import java.util.Objects;
import java.util.Optional;
import io.annot8.content.text.EditableText;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.core.data.EditableProperties;
import io.annot8.core.data.EditableTags;

public class SimpleEditableText implements EditableText {

  private String language = null;
  private final String name;
  private final String content;

  private final EditableTags tags;
  private final EditableProperties properties;
  private final TextAnnotations annotations;

  public SimpleEditableText(final String name, final String content, final TextAnnotations annotations) {
    this.name = name;
    this.content = content;
    this.annotations = annotations;
    this.tags = new SimpleEditableTags();
    this.properties = new SimpleEditableProperties();
  }


  public SimpleEditableText(final TextAnnotations annotations, final String content, final Text simpleText) {
    this.content = content;
    this.name = simpleText.getName();
    this.annotations = simpleText.getAnnotations();
    this.language = simpleText.getLanguage().orElse(null);
    this.tags = new SimpleEditableTags(simpleText.getTags());
    this.properties = new SimpleEditableProperties(simpleText.getProperties());
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
    if (!(obj instanceof SimpleEditableText))
      return false;

    final SimpleEditableText st = (SimpleEditableText) obj;

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
  public EditableProperties getProperties() {
    return properties;
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub
  }

  @Override
  public Text save() {
    // TODO implement me... we might need the item
    return new SimpleText(content, annotations, this);
  }


  @Override
  public EditableTags getTags() {
    return tags;
  }



}

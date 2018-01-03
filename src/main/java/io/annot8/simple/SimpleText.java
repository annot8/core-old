package io.annot8.simple;

import io.annot8.core.content.Text;
import io.annot8.core.exceptions.UnmodifiableDocumentException;
import java.util.Optional;
import lombok.Data;

@Data
public class SimpleText implements Text {

  private String language;

  private String content;

  @Override
  public Optional<String> getLanguage() {
    return Optional.ofNullable(language);
  }

  @Override
  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public String getContent() {
    return content;
  }

  @Override
  public void setContent(String content) throws UnmodifiableDocumentException {
    this.content = content;
  }

  @Override
  public boolean canModifyContent() {
    return true;
  }
}

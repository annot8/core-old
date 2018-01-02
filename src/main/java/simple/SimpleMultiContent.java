package simple;

import io.annot8.core.documents.Content;
import io.annot8.core.documents.MultiContent;
import io.annot8.core.exceptions.UnmodifiableDocumentException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleMultiContent implements MultiContent {

  private final Collection<Content<?>> content;

  public SimpleMultiContent(Collection<Content<?>> content) {
    this.content = content;
  }

  @Override
  public Optional<Stream<Content<?>>> getContent() {
    return Optional.of(content.stream());
  }

  @Override
  public void setContent(Stream<Content<?>> content) throws UnmodifiableDocumentException {
    throw new UnmodifiableDocumentException("Multiple content can not be changed");
  }

  @Override
  public boolean canModifyContent() {
    return false;
  }
}

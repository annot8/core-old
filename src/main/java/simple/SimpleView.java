package simple;

import io.annot8.core.components.Resource;
import io.annot8.core.context.View;
import io.annot8.core.documents.Content;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class SimpleView extends SimpleContext implements View {

  private final Content content;

  private final Set<String> tags = new HashSet<>();

  public SimpleView(Map<String, Object> configuration,
      Map<String, Resource> resources, Content content) {
    super(configuration, resources);
    this.content = content;
  }

  @Override
  public Content getContent() {
    return content;
  }

  @Override
  public Stream<String> getTags() {
    return tags.stream();
  }

  @Override
  public boolean addTag(String tag) {
    return tags.add(tag);
  }

  @Override
  public boolean removeTag(String tag) {
    return tags.remove(tag);
  }
}

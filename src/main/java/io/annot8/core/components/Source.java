package io.annot8.core.components;

import java.util.stream.Stream;
import io.annot8.core.content.Text;
import io.annot8.core.data.Item;
import io.annot8.core.stores.AnnotationStore;

/**
 * Provides content for processing from a given data source, for example a folder of files on disk,
 * or an e-mail server.
 *
 * The DataSource is responsible for finding data and converting it into a {@link Text} object ready
 * for processing by processors. If appropriate, it may also add annotations to the Text (for
 * example, file metadata) via the {@link AnnotationStore}.
 */
public interface Source extends Annot8Component {

  Stream<Item> getDataItems();
}

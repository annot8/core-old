package io.annot8.core.components;

import java.util.Iterator;

import io.annot8.core.context.Context;
import io.annot8.core.documents.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;
import io.annot8.core.stores.AnnotationStore;
import java.util.concurrent.Flow.Publisher;

/**
 * Provides documents for processing from a given data source,
 * for example a folder of files on disk, or an e-mail server.
 * 
 * The DataSource is responsible for finding data and converting
 * it into a {@link Document} object ready for processing by processors.
 * If appropriate, it may also add annotations to the Document
 * (for example, file metadata) via the {@link AnnotationStore}.
 */
public interface DataSource extends AutoCloseable, Publisher<Document>, Annot8Component{
}

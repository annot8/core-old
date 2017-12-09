package io.annot8.core.context;

import io.annot8.core.documents.Document;

public interface ViewContext extends Context {

  Document getDocument();
}

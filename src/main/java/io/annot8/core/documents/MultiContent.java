package io.annot8.core.documents;

import java.util.stream.Stream;


public interface MultiContent<T> extends Content<Stream<Content<T>>> {

}

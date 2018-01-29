package io.annot8.core.helpers.builders;

import io.annot8.core.exceptions.IncompleteException;

public interface WithBuild<A> {
    A build() throws IncompleteException;
}

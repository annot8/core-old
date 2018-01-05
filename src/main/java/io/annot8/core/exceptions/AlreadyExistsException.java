package io.annot8.core.exceptions;

public class AlreadyExistsException extends Annot8Exception {

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, Throwable t) {
        super(message, t);
    }
}
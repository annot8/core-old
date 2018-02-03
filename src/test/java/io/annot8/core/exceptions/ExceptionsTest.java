package io.annot8.core.exceptions;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionsTest {

    private static final String TEST_MESSAGE = "Test message";

    @Test
    public void testAll() throws Exception{
        testException(AlreadyExistsException.class);
        testException(Annot8Exception.class);
        testException(Annot8RuntimeException.class);
        testException(BadConfigurationException.class);
        testException(IncompleteException.class);
        testException(MissingResourceException.class);
        testException(ProcessingException.class);
        testException(UnsupportedException.class);
    }

    private void testException(Class<? extends Exception> exceptionClass) throws Exception{
        Exception e1 = exceptionClass.getConstructor(String.class).newInstance(TEST_MESSAGE);
        assertEquals(e1.getMessage(), TEST_MESSAGE);

        Exception nested = new IOException();
        Exception e2 = exceptionClass.getConstructor(String.class, Throwable.class).newInstance(TEST_MESSAGE, nested);
        assertEquals(TEST_MESSAGE, e2.getMessage());
        assertEquals(nested, e2.getCause());
    }
}

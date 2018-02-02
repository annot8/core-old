package io.annot8.core.components.responses;

import io.annot8.core.data.Item;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SourceResponseTest {
    @Test
    public void testDone(){
        SourceResponse sr = SourceResponse.done();

        assertEquals(SourceResponse.Status.DONE, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }

    @Test
    public void testOkStream(){
        SourceResponse sr = SourceResponse.ok(Stream.of(mock(Item.class), mock(Item.class)));

        assertEquals(SourceResponse.Status.OK, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testOkParameters(){
        SourceResponse sr = SourceResponse.ok(mock(Item.class), mock(Item.class));

        assertEquals(SourceResponse.Status.OK, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testOkCollection(){
        SourceResponse sr = SourceResponse.ok(Arrays.asList(mock(Item.class), mock(Item.class)));

        assertEquals(SourceResponse.Status.OK, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testSourceError(){
        SourceResponse sr = SourceResponse.sourceError();

        assertEquals(SourceResponse.Status.SOURCE_ERROR, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }

    @Test
    public void testEmpty(){
        SourceResponse sr = SourceResponse.empty();

        assertEquals(SourceResponse.Status.EMPTY, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }
}

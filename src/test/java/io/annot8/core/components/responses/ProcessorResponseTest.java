package io.annot8.core.components.responses;

import io.annot8.core.data.Item;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ProcessorResponseTest {
    @Test
    public void testOk(){
        ProcessorResponse sr = ProcessorResponse.ok();

        assertEquals(ProcessorResponse.Status.OK, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }

    @Test
    public void testOkStream(){
        ProcessorResponse sr = ProcessorResponse.ok(Stream.of(mock(Item.class), mock(Item.class)));

        assertEquals(ProcessorResponse.Status.OK, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testOkParameters(){
        ProcessorResponse sr = ProcessorResponse.ok(mock(Item.class), mock(Item.class));

        assertEquals(ProcessorResponse.Status.OK, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testOkCollection(){
        ProcessorResponse sr = ProcessorResponse.ok(Arrays.asList(mock(Item.class), mock(Item.class)));

        assertEquals(ProcessorResponse.Status.OK, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testItemStop(){
        ProcessorResponse sr = ProcessorResponse.itemStop();

        assertEquals(ProcessorResponse.Status.ITEM_STOP, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }

    @Test
    public void testItemStopStream(){
        ProcessorResponse sr = ProcessorResponse.itemStop(Stream.of(mock(Item.class), mock(Item.class)));

        assertEquals(ProcessorResponse.Status.ITEM_STOP, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testItemStopParameters(){
        ProcessorResponse sr = ProcessorResponse.itemStop(mock(Item.class), mock(Item.class));

        assertEquals(ProcessorResponse.Status.ITEM_STOP, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testItemStopCollection(){
        ProcessorResponse sr = ProcessorResponse.itemStop(Arrays.asList(mock(Item.class), mock(Item.class)));

        assertEquals(ProcessorResponse.Status.ITEM_STOP, sr.getStatus());
        assertEquals(2, sr.getItems().count());
    }

    @Test
    public void testItemError(){
        ProcessorResponse sr = ProcessorResponse.itemError();

        assertEquals(ProcessorResponse.Status.ITEM_ERROR, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }

    @Test
    public void testPipelineError(){
        ProcessorResponse sr = ProcessorResponse.pipelineError();

        assertEquals(ProcessorResponse.Status.PIPELINE_ERROR, sr.getStatus());
        assertEquals(0, sr.getItems().count());
    }
}

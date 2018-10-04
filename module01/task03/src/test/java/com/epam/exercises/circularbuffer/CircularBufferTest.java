package com.epam.exercises.circularbuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class CircularBufferTest
{
    @Test
    public void testCreateBufferWithCapacity(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(9);
        assertTrue(buffer.getCapacity() == 9);
        assertTrue(buffer.getSize() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYouCannotCreateBufferWithNegativeCapacity(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(-5);
    }

    @Test
    public void testBufferWithZeroCapacity(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(0);
        assertTrue(buffer.getCapacity() == 0);
    }

    @Test
    public void testBufferPut(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        assertTrue(buffer.getSize() == 4);
        assertTrue(buffer.getHead() == 4);
        assertTrue(buffer.getTail() == 0);
    }

    @Test(expected = RuntimeException.class)
    public void testBufferPutWhenFull(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(1);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
    }

    @Test(expected = RuntimeException.class)
    public void testBufferGetWhenEmpty(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(1);
        buffer.get();
    }

    @Test
    public void testBufferGet(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.get();
        assertTrue(buffer.getSize() == 3);
        assertTrue(buffer.getHead() == 4);
        assertTrue(buffer.getTail() == 1);
    }

    @Test
    public void testBufferGet2(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.get();
        buffer.get();
        assertTrue(buffer.getSize() == 2);
        assertTrue(buffer.getHead() == 4);
        assertTrue(buffer.getTail() == 2);
    }

    @Test
    public void testBufferPutAfterGet(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.get();
        buffer.get();
        buffer.put(11);
        assertTrue(buffer.getSize() == 3);
        assertTrue(buffer.getHead() == 0);
        assertTrue(buffer.getTail() == 2);
    }

    @Test
    public void testBufferToArray(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.get();
        buffer.get();
        buffer.put(11);
        Number[] numbers = buffer.toArray(Number.class);
        assertTrue(numbers.length == 3);
        assertEquals(numbers, new Number[]{2.0d, 1, 11});
    }

    @Test
    public void testBufferToList(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.get();
        buffer.get();
        buffer.put(11);
        List<Number> list = buffer.asList();
        assertTrue(list.size() == 3);
        assertEquals(list, Arrays.asList(2.0d, 1, 11));
    }

    @Test
    public void testBufferSort() {
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.sort((o1, o2) -> Double.valueOf("" + o1).compareTo(Double.valueOf("" + o2)));
        assertEquals(buffer.getElementData(), new Object[]{0, 1, 2.0, Long.MAX_VALUE});
    }
    // [0, 1, 2.0, 9223372036854775807]


}

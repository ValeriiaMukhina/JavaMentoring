package com.epam.exercises.circularbuffer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class CircularBufferTest
{
    @Test
    public void testCreateBufferWithCapacity(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(9);
        assertEquals(9, buffer.getCapacity());
        assertEquals(0, buffer.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYouCannotCreateBufferWithNegativeCapacity(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(-5);
    }

    @Test
    public void testBufferPut(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        assertEquals(4, buffer.getSize());
        assertEquals(4, buffer.getHead());
        assertEquals(0, buffer.getTail());
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
        assertEquals(3, buffer.getSize());
        assertEquals(4, buffer.getHead());
        assertEquals(1, buffer.getTail());
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
        assertEquals(2, buffer.getSize());
        assertEquals(4, buffer.getHead());
        assertEquals(2, buffer.getTail());
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
        assertEquals(3, buffer.getSize());
        assertEquals(0, buffer.getHead());
        assertEquals(2, buffer.getTail());
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
        assertEquals(3, numbers.length);
        assertArrayEquals(numbers, new Number[]{2.0d, 1, 11});
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
        assertEquals(3, list.size());
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
        assertArrayEquals(buffer.getElementData(), new Object[]{0, 1, 2.0, Long.MAX_VALUE});
    }
    // [0, 1, 2.0, 9223372036854775807]

    @Test
    public void testBufferSort2() {
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.sort2((o1, o2) -> Double.valueOf("" + o1).compareTo(Double.valueOf("" + o2)));
        assertArrayEquals(buffer.getElementData(), new Object[]{0, 1, 2.0, Long.MAX_VALUE, null});
    }

    @Test
    public void testBufferToArray2(){
        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.get();
        buffer.get();
        buffer.put(11);
        Number[] numbers = buffer.toArray();
        assertEquals(3, numbers.length);
        assertArrayEquals(numbers, new Number[]{2.0d, 1, 11});
    }
}
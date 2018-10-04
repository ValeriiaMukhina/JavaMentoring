package com.epam.exercises.circularbuffer;

import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CircularBuffer<Integer> circularBuffer = new CircularBuffer<>(5);
        circularBuffer.put(3);
        circularBuffer.put(4);
        circularBuffer.put(5);
        circularBuffer.put(7);
        circularBuffer.get();
        circularBuffer.put(8);
        circularBuffer.put(6);
        circularBuffer.get();
        circularBuffer.put(11);
// 3 4 5 7
//   4 5 7
//   4 5 7 8
// 6 4 5 7 8
// 6   5 7 8
// 6 115 7 8
        List<Integer> list = circularBuffer.asList();
        System.out.println(list);

        circularBuffer.get();
        circularBuffer.get();
// 6 11  7 8
// 6 11    8

        circularBuffer.sort(Comparator.naturalOrder());
        System.out.println(circularBuffer);


        CircularBuffer<Number> buffer = new CircularBuffer<>(5);
        buffer.put(Long.MAX_VALUE);
        buffer.put(0);
        buffer.put(2.0d);
        buffer.put(1);
        buffer.sort((o1, o2) -> Double.valueOf("" + o1).compareTo(Double.valueOf("" + o2)));
        System.out.println(buffer);

        // [0, 1, 2.0, 9223372036854775807]
    }
}

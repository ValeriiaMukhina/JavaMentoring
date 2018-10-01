package exercises;

import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
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
        System.out.println( list );

        circularBuffer.get();
        circularBuffer.get();
// 6 11  7 8
// 6 11    8

circularBuffer.sort(Comparator.naturalOrder());
        System.out.println( circularBuffer);
    }
}

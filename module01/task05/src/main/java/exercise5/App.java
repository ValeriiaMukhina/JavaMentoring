package exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class App {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    private static List<String> possibleValues = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
    private static AtomicBoolean passwordCracked = new AtomicBoolean(false);
    private static volatile boolean isCracked;
    private static String password = "cabg";
    private static String hashedPassword = new HashCalculator().hash(password);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hashed password = " + hashedPassword);

        ExecutorService executor = Executors.newFixedThreadPool(7);//two threads, try setting by 1 to observe time
        System.out.println("Starting ...");

        long start = System.currentTimeMillis();

        Runnable taskToVerifyGuess =
                () -> {
                    try {
                        verifyPossiblePassword();
                    } catch (InterruptedException ignored) {
                    }
                };
        

        for (int i = 0; i < 2; i++) {//worker.run is called 2 (threads started) times by two threads
            executor.submit(taskToVerifyGuess);
        }
        for (int length = 1; length <= possibleValues.size(); length++) {
            final int finalLength = length;
            executor.submit(new Runnable() {
                public void run() {
                    try {
                        generateCombinations(finalLength, possibleValues);
                    } catch (InterruptedException ignored) {
                    }
                }
            });
        }
        executor.shutdown(); //prevents new tasks from being accepted by the ExecutorService
        try {
            executor.awaitTermination(2, TimeUnit.MINUTES);
            System.out.println("task completed");
        } catch (InterruptedException ex) {
            System.out.println("Forcing shutdown...");
            executor.shutdownNow();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken in milliseconds: " + (end - start));


    }

    private static void generateCombinations(int arraySize, List<String> possibleValues) throws InterruptedException {
        while (!isCracked) {
            int carry;
            int[] indices = new int[arraySize];
            do {
                StringBuffer sb = new StringBuffer();
                for (int index : indices)
                    sb.append(possibleValues.get(index));
                queue.put(sb.toString());
                System.out.println(sb.toString());

                carry = 1;
                for (int i = indices.length - 1; i >= 0; i--) {
                    if (carry == 0)
                        break;

                    indices[i] += carry;
                    carry = 0;

                    if (indices[i] == possibleValues.size()) {
                        carry = 1;
                        indices[i] = 0;
                    }
                }
            }
            while (carry != 1); // Call this method iteratively until a carry is left over
        }
    }

    private static void verifyPossiblePassword() throws InterruptedException {
        while (!isCracked) {
            String value = queue.take();//if queue is empty waits
            String hash = new HashCalculator().hash(value);
            System.out.println("I am verifying guess = " + value);
            if (hashedPassword.equals(hash)) {
                passwordCracked.compareAndSet(false, true);
                isCracked = true;
                System.out.println("You password is " + value);
                return;
            }

        }
    }
}

package exercise5;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class PasswordCracker {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    private static List<String> possibleValues = Arrays.asList("a", "b", "c", "d");
    private static volatile boolean isCracked;
    private static String password = "cab";
    private static String hashedPassword = new HashCalculator().hash(password);




    public static void start() throws InterruptedException {

        System.out.println("Hashed password = " + hashedPassword);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Starting ...");

        long start = System.currentTimeMillis();

        executor.submit(new Consumer());


        for (int i = 1; i <= possibleValues.size(); i++)
            if (!isCracked) {
                executor.submit(new Generator1(i));
            }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("task completed");
        } catch (InterruptedException ex) {
            System.out.println("Forcing shutdown...");
            executor.shutdownNow();
        }
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + DurationFormatUtils.formatDuration((end - start), "HH:mm:ss.S"));


    }


    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                verifyPossiblePassword();
            } catch (InterruptedException ignored) {
            }
        }

        private void verifyPossiblePassword() throws InterruptedException {
            while (!isCracked) {
                String value = queue.take();
                String hash = new HashCalculator().hash(value);
                System.out.println("I am verifying guess = " + value);
                if (hashedPassword.equals(hash)) {
                    isCracked = true;
                    System.out.println("You password is " + value);
                    return;
                }

            }
        }
    }


    public static class Generator1 implements Runnable {
        int length;

        public Generator1(int length) {
            this.length = length;
        }

        private void generateCombinations(int arraySize, List<String> possibleValues) throws InterruptedException {
            int carry;
            int[] indices = new int[arraySize];
            do {
                StringBuffer sb = new StringBuffer();
                for (int index : indices)
                    sb.append(possibleValues.get(index));
                if (isCracked) return;
                System.out.println(sb.toString());
                queue.offer(sb.toString(), 100, TimeUnit.MILLISECONDS);
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
            while (carry != 1 && !isCracked);
        }

        public void run() {
            try {
                generateCombinations(length, possibleValues);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

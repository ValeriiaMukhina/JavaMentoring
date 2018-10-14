package exercise5;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class PasswordCracker {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    private String charset = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    private  List<String> possibleValues = new ArrayList<>(Arrays.asList(charset.split(",")));
    private volatile boolean isCracked;
    private String hashedPassword;

    PasswordCracker(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    void bruteForce() throws InterruptedException {

        System.out.println("Hashed password = " + hashedPassword);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("Starting ...");

        long start = System.currentTimeMillis();

       for (int i = 1; i <= 3; i++) {
            executor.submit(new PasswordChecker());

       }


        for (int passwordLength = 1; passwordLength <= possibleValues.size(); passwordLength++)
            if (!isCracked) {
                executor.submit(new Generator(passwordLength));
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


    class PasswordChecker implements Runnable {

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
                    System.out.println("Your password = " + value);
                    return;
                }

            }
        }
    }


    class Generator implements Runnable {
        int length;

        Generator(int length) {
            this.length = length;
        }

        private void generateCombinations(int arraySize, List<String> possibleValues) throws InterruptedException {
            int carry;
            int[] indices = new int[arraySize];
            do {
                StringBuilder sb = new StringBuilder();
                if(isCracked) return;
                for (int index : indices)
                    sb.append(possibleValues.get(index));
                System.out.println(sb.toString());
                queue.offer(sb.toString(), 100, TimeUnit.MILLISECONDS);
                carry = 1;
                if(isCracked) return;
                for (int i = indices.length - 1; i >= 0; i--) {
                    if (carry == 0)
                        break;

                    indices[i] += carry;
                    carry = 0;

                    if (indices[i] == possibleValues.size()) {
                        if(isCracked) return;
                        carry = 1;
                        indices[i] = 0;
                    }
                }
            }
            while (carry != 1 && !isCracked);
        }

        @Override
        public void run() {
            try {
                if(!isCracked) generateCombinations(length, possibleValues);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
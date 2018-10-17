package exercise5;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class PasswordCrackerImproved {

    private static Logger LOGGER = LoggerFactory.getLogger(PasswordCrackerImproved.class);

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    private String charset = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    private List<String> possibleValues = new ArrayList<>(Arrays.asList(charset.split(",")));
    private volatile boolean isCracked;
    private String hashedPassword;

    PasswordCrackerImproved(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    void bruteForce(int numberOfThreads) throws InterruptedException {

        LOGGER.info("Hashed password = {}",  hashedPassword);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        LOGGER.info("Starting ...");

        long start = System.currentTimeMillis();
        for (int passwordLength = 1; passwordLength <= possibleValues.size(); passwordLength++)
            if (!isCracked) {
                executor.submit(new Generator(passwordLength));
            }

        CompletionService<String> ecs = new ExecutorCompletionService<>(executor);
        List<Future<String>> futures = new ArrayList<>();
        String result = null;
        try {
            for (int i = 1; i <= 3; i++)
                futures.add(ecs.submit(new PasswordChecker()));


            for (int i = 0; i < numberOfThreads; ++i) {
                try {
                    String r = ecs.take().get();
                    if (r != null) {
                        result = r;
                        break;
                    }
                } catch (ExecutionException ignore) {
                }
            }
        } finally {
            for (Future<String> f : futures)
                f.cancel(true);
        }

        if (result != null)
            LOGGER.info("Your result = {}", result);

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
            LOGGER.info("task completed");
        } catch (InterruptedException ex) {
            LOGGER.info("Forcing shutdown...");
            executor.shutdownNow();
        }

        long end = System.currentTimeMillis();
        LOGGER.info("Time taken: {}", DurationFormatUtils.formatDuration((end - start), "HH:mm:ss.S"));
    }


    class PasswordChecker implements Callable<String> {

        private String verifyPossiblePassword() throws InterruptedException {
            while (!isCracked) {
                String value = queue.take();
                String hash = new HashCalculator().hash(value);
                LOGGER.debug("I am verifying guess = {}",  value);
                if (hashedPassword.equals(hash)) {
                    isCracked = true;
                    LOGGER.debug("Your password = {}", value);
                    return value;
                }

            }
            return null;
        }

        @Override
        public String call() throws Exception {
            String password = null;
            try {
                password = verifyPossiblePassword();
            } catch (InterruptedException ignored) {
            }
            return password;
        }
    }


    class Generator implements Runnable {
        int length;

        Generator(int length) {
            this.length = length;
        }

        private void generateCombinations(int possiblePasswordLength, List<String> possibleValues) throws InterruptedException {
            int flag;
            int[] indices = new int[possiblePasswordLength];
            do {
                StringBuilder sb = new StringBuilder();
                if (isCracked) return;
                for (int index : indices)
                    sb.append(possibleValues.get(index));
                if (isCracked) return;
                LOGGER.debug("combination:{}", sb.toString());
                queue.offer(sb.toString(), 100, TimeUnit.MILLISECONDS);
                flag = 1;
                if (isCracked) return;
                for (int i = indices.length - 1; i >= 0; i--) {
                    if (flag == 0 || (isCracked))
                        break;

                    indices[i] += flag;
                    flag = 0;

                    if (indices[i] == possibleValues.size()) {
                        if (isCracked) return;
                        flag = 1;
                        indices[i] = 0;
                    }
                }
            }
            while (flag != 1 && !isCracked);
        }

        @Override
        public void run() {
            try {
                if (!isCracked) generateCombinations(length, possibleValues);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
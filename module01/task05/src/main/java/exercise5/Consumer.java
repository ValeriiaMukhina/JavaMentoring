package exercise5;

import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {

    static boolean isCracked;
    private static BlockingQueue<String> queue;
    private static String hashedPassword;

    Consumer( String hashedPassword, BlockingQueue<String> queue, boolean isCracked) {
        this.hashedPassword = hashedPassword;
        this.queue = queue;
        this.isCracked = isCracked;
    }

    @Override
    public void run() {
        try {
            verifyPossiblePassword();
        } catch (InterruptedException ignored) {
        }
    }

    private static void verifyPossiblePassword() throws InterruptedException {
        while (!isCracked) {
            String value = queue.take();//if queue is empty waits
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

package exercise5;

public class App {

    public static void main(String[] args) throws InterruptedException {
        String passwordToCrack = "ababc";
        int numberOfThreads = Runtime.getRuntime().availableProcessors() * 8;
        String hashedPassword = new HashCalculator().hash(passwordToCrack);
        new PasswordCrackerImproved(hashedPassword).bruteForce(numberOfThreads);
    }

}

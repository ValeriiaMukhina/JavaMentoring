package exercise5;

public class App {

    public static void main(String[] args) throws InterruptedException {
        String password = "cab";
        int numberOfThreads = Runtime.getRuntime().availableProcessors() * 8;
        String hashedPassword = new HashCalculator().hash(password);
        new PasswordCracker(hashedPassword).bruteForce(numberOfThreads);
    }

}

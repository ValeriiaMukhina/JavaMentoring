package exercise5;

public class App {

    public static void main(String[] args) throws InterruptedException {
        String passwordToCrack = "lera";
        int numberOfThreads = Runtime.getRuntime().availableProcessors() * 8;
        String hashedPassword = new HashCalculator().hash(passwordToCrack);
        new PasswordCracker(hashedPassword).bruteForce(numberOfThreads);
    }

}

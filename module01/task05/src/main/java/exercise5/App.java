package exercise5;

public class App {

    private static String password = "cab";
    private static String hashedPassword = new HashCalculator().hash(password);

    public static void main(String[] args) throws InterruptedException {
        new PasswordCracker(hashedPassword).bruteForce();
    }

}

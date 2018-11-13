package runner;

/**
 * Class to start application.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class App {
    private App() {
    }
    /**
     * main method to start application.
     *
     * @param args from console
     */
    public static void main(String[] args) {
        new AppRunner().start();
    }
}

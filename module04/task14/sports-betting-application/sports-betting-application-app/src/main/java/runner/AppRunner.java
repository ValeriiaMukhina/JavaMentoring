package runner;


import domain.user.Player;
import utils.Printer;

/**
 * Class for obtain player and start a game with player.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class AppRunner {
    /**
     * Main Application runner.
     * @author  Valeriia Biruk
     * @version 1.0
     */
    public void start() {

        Printer.printToConsole("Welcome");
        Printer.printToConsole("==============================");

        Player player = GameDataGenerator.getUserFromConsole();

        new Game(player, GameDataGenerator.createTestData()).start();

    }
}

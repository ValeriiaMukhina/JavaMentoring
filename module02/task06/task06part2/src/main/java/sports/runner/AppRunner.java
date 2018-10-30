package sports.runner;

import sports.domain.user.Player;
import sports.domain.user.factories.PlayerFactory;
import sports.utils.*;

/**
 * Class for obtain player and start a game with player.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class AppRunner {

    public void start() {

        Printer.printToConsole("Welcome");
        Printer.printToConsole("==============================");

        Player player = (Player) new PlayerFactory().getFromConsole();

        new Game(player, GameDataGenerator.createTestData()).start();

    }
}

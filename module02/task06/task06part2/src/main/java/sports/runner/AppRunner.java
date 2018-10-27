package sports.runner;

import sports.domain.user.Player;
import sports.domain.user.factories.PlayerFactory;
import sports.utils.*;


public class AppRunner {

    public void start() {

        Printer.printToConsole("Welcome");
        Printer.printToConsole("==============================");

        Player player = (Player) new PlayerFactory().getFromConsole();

        new Game(player, GameDataGenerator.createTestData()).start();

    }
}
package runner;


import domain.user.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import utils.Printer;

import java.util.Locale;

/**
 * Class for obtain player and start a game with player.
 * @author  Valeriia Biruk
 * @version 1.0
 */
@Component
public class AppRunner {
    /**
     * Main Application runner.
     * @author  Valeriia Biruk
     * @version 1.0
     */
    @Autowired Game game;
    @Autowired
    MessageSource messageSource;

    public void start() {

        Printer.printToConsole(messageSource.getMessage("game.welcome", new Object[]{},
                Locale.getDefault()));
        Printer.printToConsole("==============================");

        game.start();

    }
}

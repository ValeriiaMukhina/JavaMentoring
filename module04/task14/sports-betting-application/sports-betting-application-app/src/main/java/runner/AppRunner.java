package runner;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import utils.Printer;
/**
 * Class for obtain player and start a game with player.
 * @author  Valeriia Biruk
 * @version 1.0
 */
@Component
@Lazy
public class AppRunner {
    @Autowired private Game game;
    @Autowired private MessageSource messageSource;
    /**
     * Main Application runner.
     * @author  Valeriia Biruk
     * @version 1.0
     */
    public void start() {

        Printer.printToConsole(messageSource.getMessage("game.welcome", new Object[]{},
                Locale.getDefault()));
        Printer.printToConsole("==============================");

        game.start();

    }
}

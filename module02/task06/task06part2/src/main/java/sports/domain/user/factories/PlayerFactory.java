package sports.domain.user.factories;

import sports.domain.user.Player;
import sports.domain.user.User;
import sports.utils.ConsoleReader;
import sports.utils.DataUtils;
import sports.utils.Printer;
import sports.utils.validation.CurrencyValidator;
import sports.utils.validation.DateValidator;
import sports.utils.validation.DoubleValidator;
import sports.utils.validation.InputValidator;

/**
 * Abstract factory pattern used for getting players.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class PlayerFactory implements UserFactory {

    @Override
    public User getFromConsole() {
            Player player = new Player();
            Printer.printToConsole("> Hi, what is your name?");
            player.setName(ConsoleReader.read(new InputValidator(){}));
            Printer.printToConsole("> What is your account number?");
            player.setAccountNumber(ConsoleReader.read(new InputValidator(){}));
            Printer.printToConsole("> How much money do you have (more than 0)?");
            player.setBalance(Double.parseDouble(ConsoleReader.read(new DoubleValidator())));
            Printer.printToConsole("> What is your currency? (USD, EUR or HUF)");
            player.setCurrency(DataUtils.getCurrency(ConsoleReader.read(new CurrencyValidator())));
            Printer.printToConsole("> When were you born? eg.:1990-02-03");
            player.setDateOfBirth(DataUtils.getDate(ConsoleReader.read(new DateValidator())));
            return player;

    }
}

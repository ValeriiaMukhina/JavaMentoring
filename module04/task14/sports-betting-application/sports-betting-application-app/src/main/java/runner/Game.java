package runner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import domain.betting.Outcome;
import domain.betting.OutcomeOdd;
import domain.betting.SportEvent;
import domain.betting.Wager;
import domain.user.Player;
import service.BetCalculationService;
import service.PossibleBetDescription;
import utils.ConsoleReader;
import utils.DataUtils;
import utils.Printer;
import utils.validation.DoubleValidator;
import utils.validation.OptionValidator;

/** gambling game class.
 * @author Valeriia Biruk
 * @version 1.0
 */
@Component
public class Game {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private GameDataGenerator gameDataGenerator;
    @Autowired
    private OptionValidator optionValidator;
    @Autowired
    private DoubleValidator doubleValidator;
    @Autowired
    private Printer printer;

    private Player player;
    private List<SportEvent> sportEvents;

    @Autowired
    private BetCalculationService service;

    private List<Wager> wagers = new ArrayList<>();
    /** init method to initialize bean.
     */
    @PostConstruct
    public void init() {
        this.player = gameDataGenerator.getUserFromConsole();
        this.sportEvents = gameDataGenerator.createTestData();
    }
    /** start game.
     */

    public void start() {
        salutateNewPlayer();
        boolean exit = false;

        List<PossibleBetDescription> possibleBetDescriptions = service.listAllBets(sportEvents);
        while (!exit) {
            int answer = askToChooseBet(possibleBetDescriptions);
            if (answer == 0) {
                exit = true;
                service.generateResults(sportEvents);
                List<Outcome> realOutcomes = service.getRealOutcomes(sportEvents);
                List<Double> prizes = service.calculatedPrizes(realOutcomes, wagers);
                Printer.printRealOutcomes(realOutcomes);
                Printer.printPrizes(prizes);
            } else {
                createNewWage(possibleBetDescriptions, answer);
            }

        }
    }

    private void salutateNewPlayer() {
        Printer.printToConsole(messageSource.getMessage("game.greeting", new Object[]{player.getName()},
                Locale.getDefault()));
        Printer.printToConsole(messageSource.getMessage("game.balance", new Object[]{player.getBalance(), player.getCurrency()},
                Locale.getDefault()));
    }

    private void createNewWage(List<PossibleBetDescription> possibleBetDescriptions, int answer) {
        OutcomeOdd outcomeOdd = service.getPossibleBetDescriptionByIndex(possibleBetDescriptions, answer).getOutcomeOdd();
        Printer.printToConsole(messageSource.getMessage("game.askBet", new Object[]{},
                Locale.getDefault()));
        double wage = Double.parseDouble(ConsoleReader.read(doubleValidator));

        if (wage > player.getBalance()) {
            Printer.printToConsole(messageSource.getMessage("game.notEnoughMoney", new Object[]{player.getBalance(), player.getCurrency()},
                    Locale.getDefault()));
        } else {
            player.setBalance(player.getBalance() - wage);
            Printer.printToConsole(messageSource.getMessage("game.balance", new Object[]{player.getBalance(), player.getCurrency()},
                    Locale.getDefault()));
            Wager wager = new Wager(player, outcomeOdd, wage, LocalDateTime.now());
            wagers.add(wager);
        }
    }

    private int askToChooseBet(List<PossibleBetDescription> possibleBetDescriptions) {
        Printer.printToConsole(messageSource.getMessage("game.askOption", new Object[]{},
                Locale.getDefault()));
        possibleBetDescriptions.forEach(possibleBet -> Printer.printToConsole(possibleBet.toString()));
        optionValidator.setOptionMaxValue(possibleBetDescriptions.size());
        return DataUtils.getOption(ConsoleReader.read(optionValidator));
    }

    public List<Wager> getWagers() {
        return wagers;
    }

}

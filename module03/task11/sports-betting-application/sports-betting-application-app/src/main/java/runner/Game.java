package runner;


import domain.betting.*;
import domain.user.Player;
import service.BetCalculationService;
import utils.ConsoleReader;
import utils.DataUtils;
import utils.Printer;
import utils.validation.DoubleValidator;
import utils.validation.OptionValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Valeriia Biruk
 * @version 1.0
 */
public class Game {

    private Player player;
    private List<SportEvent> sportEvents;
    private BetCalculationService service = new BetCalculationService();
    private List<Wager> wagers = new ArrayList<>();

    public Game(Player player, List<SportEvent> sportEvents) {
        this.player = player;
        this.sportEvents = sportEvents;
    }


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
        Printer.printToConsole("> Hi, " + player.getName());
        Printer.printToConsole("> Your balance is: " + player.getBalance() + " " + player.getCurrency());
    }

    private void createNewWage(List<PossibleBetDescription> possibleBetDescriptions, int answer) {
        OutcomeOdd outcomeOdd = service.getPossibleBetDescriptionByIndex(possibleBetDescriptions, answer).getOutcomeOdd();
        Printer.printToConsole("> How much do you want to bet on it?");
        double wage = Double.parseDouble(ConsoleReader.read(new DoubleValidator()));

        if (wage > player.getBalance()) {
            Printer.printToConsole("> You don't have enough money, your balance is: " + player.getBalance() + " " + player.getCurrency());

        } else {
            player.setBalance(player.getBalance() - wage);
            Printer.printToConsole("> Your balance is: " + player.getBalance() + player.getCurrency());
            Wager wager = new Wager(player, outcomeOdd, wage, player.getCurrency(), LocalDateTime.now(), State.UNPROCESSED);
            wagers.add(wager);
        }
    }

    private int askToChooseBet(List<PossibleBetDescription> possibleBetDescriptions) {
        Printer.printToConsole("> Please choose an outcome to bet on! (choose a number or press q for quit)");
        possibleBetDescriptions.forEach(possibleBet -> Printer.printToConsole(possibleBet.toString()));
        return DataUtils.getOption(ConsoleReader.read(new OptionValidator(possibleBetDescriptions.size())));
    }
}

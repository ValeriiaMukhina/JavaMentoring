package sports.runner;

import sports.domain.betting.*;
import sports.domain.user.Player;
import sports.service.BetCalculationService;
import sports.utils.*;
import sports.utils.validation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppRunner {

    public void start() {

        Printer.printToConsole("Welcome");
        Printer.printToConsole("==============================");

        List<SportEvent> sportEvents = TestDataGenerator.createTestData();

        List<Wager> wagers = new ArrayList<>();
        BetCalculationService service = new BetCalculationService();

        Player player = getPlayer();
        salutateNewPlayer(player);

        boolean exit = false;

        List<PossibleBetDescription> possibleBetDescriptions = service.listAllBets(sportEvents);

        while (!exit) {
            int answer = askToChooseBet(possibleBetDescriptions);
            if (answer == 0) {
                exit = true;
                service.generateResults(sportEvents);
                List<Outcome> realOutcomes  = service.getRealOutcomes(sportEvents);
                List<Double> prizes = service.calculatedPrizes(realOutcomes, wagers);
                Printer.printRealOutcomes(realOutcomes);
                Printer.printPrizes(prizes);
            } else {
                createNewWage(wagers, service, player, possibleBetDescriptions, answer);
            }

        }
    }

    private void createNewWage(List<Wager> wagers, BetCalculationService service, Player player, List<PossibleBetDescription> possibleBetDescriptions, int answer) {
        OutcomeOdd outcomeOdd = service.getPossibleBetDescriptionByIndex(possibleBetDescriptions, answer).getOutcomeOdd();
        Printer.printToConsole("> How much do you want to bet on it? (q for quit)");
        double wage = Double.parseDouble(ConsoleReader.read(new DoubleValidator()));

        if (wage > player.getBalance()) {
            Printer.printToConsole("> You don't have enough money, your balance is: " + player.getBalance() + player.getCurrency());

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

    private void salutateNewPlayer(Player player) {
        Printer.printToConsole("> Hi, " + player.getName());
        Printer.printToConsole("> Your balance is: " + player.getBalance() + " " + player.getCurrency());
    }

    private Player getPlayer() {
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
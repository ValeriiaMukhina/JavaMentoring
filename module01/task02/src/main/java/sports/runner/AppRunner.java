package sports.runner;

import sports.domain.betting.*;
import sports.domain.user.Player;
import sports.service.Service;
import sports.utils.ConsoleReader;
import sports.utils.Printer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppRunner {

    public void start() {

        Printer.printToConsole("Welcome");
        Printer.printToConsole("==============================");

        List<SportEvent> sportEvents = TestDataGenerator.createTestData();

        List<Wager> wagers = new ArrayList<>();
        Service service = new Service();

        Player player = getPlayer();
        salutateNewPlayer(player);

        boolean exit = false;

        List<PossibleBetDescription> possibleBetDescriptions = service.listAllBets(sportEvents);

        while (!exit) {
            int answer = askToChooseBet(possibleBetDescriptions);
            if (answer == 0) {
                exit = true;
                service.generateResults(sportEvents);
                service.calculatePrize(sportEvents, wagers);
            } else {
                createNewWage(wagers, service, player, possibleBetDescriptions, answer);
            }

        }
    }

    private void createNewWage(List<Wager> wagers, Service service, Player player, List<PossibleBetDescription> possibleBetDescriptions, int answer) {
        OutcomeOdd outcomeOdd = service.getPossibleBetDescriptionByIndex(possibleBetDescriptions, answer).getOutcomeOdd();
        Printer.printToConsole("> How much do you want to bet on it? (q for quit)");
        double wage = ConsoleReader.readOneDoubleFromConsole();

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
        possibleBetDescriptions.forEach(possibleBet -> System.out.println(possibleBet.toString()));
        return ConsoleReader.readOption(possibleBetDescriptions.size());
    }

    private void salutateNewPlayer(Player player) {
        Printer.printToConsole("> Hi, " + player.getName());
        Printer.printToConsole("> Your balance is: " + player.getBalance() + " " + player.getCurrency());
    }

    private Player getPlayer() {
        Player player = new Player();
        Printer.printToConsole("> Hi, what is your name?");
        player.setName(ConsoleReader.readFromConsole());
        Printer.printToConsole("> What is your account number?");
        player.setAccountNumber(ConsoleReader.readFromConsole());
        Printer.printToConsole("> How much money do you have (more than 0)?");
        player.setBalance(ConsoleReader.readOneDoubleFromConsole());
        Printer.printToConsole("> What is your currency? (USD, EUR or HUF)");
        player.setCurrency(ConsoleReader.readCurrencyFromConsole());
        Printer.printToConsole("> When were you born? eg.:1990-02-03");
        player.setDateOfBirth(ConsoleReader.readDate());
        return player;
    }
}
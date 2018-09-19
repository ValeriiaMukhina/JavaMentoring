package sports.runner;

import sports.domain.betting.*;
import sports.domain.user.Player;
import sports.service.Service;
import sports.utils.ConsoleReader;
import sports.utils.Printer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppRunner {

    public void start() {

        Printer.printToConsole("Welcome");
        Printer.printToConsole("==============================");
        Player player = getPlayer();
        salutateNewPlayer(player);

        List<SportEvent> sportEvents = createTestData();
        Service service = new Service();
       service.listAllBets(sportEvents).forEach(possibleBet -> System.out.println(possibleBet.toString()));

//        boolean exit = false;
//        while (!exit) {
//
//
//
//        }
    }

    private void salutateNewPlayer(Player player) {
        Printer.printToConsole("> Hi, " + player.getName());
        Printer.printToConsole("> Your balance is , " + player.getBalance() + player.getCurrency());
    }

    private Player getPlayer() {
        Player player = new Player();
        Printer.printToConsole("> Hi, what is your name?");
        player.setName(ConsoleReader.readFromConsole());
        Printer.printToConsole("> What is your account number?");
        player.setAccountNumber(ConsoleReader.readFromConsole());
        Printer.printToConsole("> How much money do you have (more than 0)?");
        player.setBalance(ConsoleReader.readOneDoubleFromConsole());
        Printer.printToConsole("> What is your currency? (UAH, EUR or USD)");
        player.setCurrency(ConsoleReader.readCurrencyFromConsole());
        Printer.printToConsole("> When were you born? eg.:1990-02-03");
        player.setDateOfBirth(ConsoleReader.readDate());
        return player;
    }



    public static List<SportEvent> createTestData() {
        List<SportEvent> sportEvents = new ArrayList<>();
        FootballSportEvent footballSportEvent = FootballSportEvent.newBuilder()
                .setTitle("Southampton v Bournemoth")
                .setStartDate(LocalDateTime.of(2016, 10,7,19,0))
                .setEndDate(LocalDateTime.of(2016, 10,7,21,0))
                .build();


        Outcome outcome111 = Outcome.newBuilder()
                .setValue("Southampton")
                .setOdd(new OutcomeOdd(4.0, LocalDateTime.of(2016, 9,27,19,0),
                        LocalDateTime.of(2016, 9,30,18,59)))
                .setOdd(new OutcomeOdd(5.0, LocalDateTime.of(2016, 9,30,19,0)))
                .build();

        Outcome outcome112 = Outcome.newBuilder()
                .setValue("Bournemoth")
                .setOdd(new OutcomeOdd(1.7, LocalDateTime.of(2016, 9,27,19,0),
                        LocalDateTime.of(2016, 9,30,18,59)))
                .setOdd(new OutcomeOdd(1.5, LocalDateTime.of(2016, 9,30,19,0)))
                .build();

        Outcome outcome113 = Outcome.newBuilder()
                .setValue("Draw")
                .setOdd(new OutcomeOdd(3.0, LocalDateTime.of(2016, 9,27,19,0),
                        LocalDateTime.of(2016, 9,30,18,59)))
                .setOdd(new OutcomeOdd(3.5, LocalDateTime.of(2016, 9,30,19,0)))
                .build();

        Bet betFootball1 = Bet.newBuilder()
                .setBetType(BetTypes.BETTING_FOR_WINNER)
                .setDescription("--")
                .setOutcome(outcome111)
                .setOutcome(outcome112)
                .setOutcome(outcome113)
                .build();

        footballSportEvent.getBets().add(betFootball1);

        Outcome outcome121 = Outcome.newBuilder()
                .setValue("0")
                .setOdd(new OutcomeOdd(1.75, LocalDateTime.of(2016, 9,27,19,0)))
                .build();

        Outcome outcome122 = Outcome.newBuilder()
                .setValue("1")
                .setOdd(new OutcomeOdd(1.25, LocalDateTime.of(2016, 9,27,19,0)))
                .build();

        Outcome outcome123 = Outcome.newBuilder()
                .setValue(">2")
                .setOdd(new OutcomeOdd(1.05, LocalDateTime.of(2016, 9,27,19,0)))
                .build();

        Bet betFootball2 = Bet.newBuilder()
                .setBetType(BetTypes.BETTING_FOR_GOALS)
                .setDescription("--")
                .setOutcome(outcome121)
                .setOutcome(outcome122)
                .setOutcome(outcome123)
                .build();

        footballSportEvent.getBets().add(betFootball2);

        TennisSportEvent tennisSportEvent = TennisSportEvent.newBuilder()
                .setTitle("Rafael Nadal vs. Alexander Zverev, Indian Wells 4th Round")
                .setStartDate(LocalDateTime.of(2016, 8,10,19,0))
                .setEndDate(LocalDateTime.of(2016, 8,10,22,0))
                .build();

        Outcome outcome211 = Outcome.newBuilder()
                .setValue("Rafael Nadal")
                .setOdd(new OutcomeOdd(1.01, LocalDateTime.of(2016, 1,1,0,0)))
                .build();

        Outcome outcome212 = Outcome.newBuilder()
                .setValue("Alexander Zverev")
                .setOdd(new OutcomeOdd(1.7, LocalDateTime.of(2016, 1,1,0,0)))
                .build();

        Bet betTennis1 = Bet.newBuilder()
                .setBetType(BetTypes.BETTING_FOR_WINNER)
                .setDescription("--")
                .setOutcome(outcome211)
                .setOutcome(outcome212)
                .build();

        tennisSportEvent.getBets().add(betTennis1);
        sportEvents.add(tennisSportEvent);
        sportEvents.add(footballSportEvent);

        return sportEvents;
    }




}
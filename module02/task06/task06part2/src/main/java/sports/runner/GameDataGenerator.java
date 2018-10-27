package sports.runner;

import sports.domain.betting.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static sports.domain.betting.Bet.newBuilder;

public class GameDataGenerator {
    public static List<SportEvent> createTestData() {
        List<SportEvent> sportEvents = new ArrayList<>();
        FootballSportEvent footballSportEvent = FootballSportEvent.newBuilder()
                .setTitle("Southampton vs Bournemoth")
                .setStartDate(LocalDateTime.of(2016, 10, 7, 19, 0))
                .setEndDate(LocalDateTime.of(2016, 10, 7, 21, 0))
                .build();


        Outcome outcome111 = Outcome.newBuilder()
                .setValue("Southampton")
                .setOdd(new OutcomeOdd(4.0, LocalDateTime.of(2016, 9, 27, 19, 0),
                        LocalDateTime.of(2016, 9, 30, 18, 59)))
                .setOdd(new OutcomeOdd(5.0, LocalDateTime.of(2016, 9, 30, 19, 0)))
                .build();

        Outcome outcome112 = Outcome.newBuilder()
                .setValue("Bournemoth")
                .setOdd(new OutcomeOdd(1.7, LocalDateTime.of(2016, 9, 27, 19, 0),
                        LocalDateTime.of(2016, 9, 30, 18, 59)))
                .setOdd(new OutcomeOdd(1.5, LocalDateTime.of(2016, 9, 30, 19, 0)))
                .build();

        Outcome outcome113 = Outcome.newBuilder()
                .setValue("Draw")
                .setOdd(new OutcomeOdd(3.0, LocalDateTime.of(2016, 9, 27, 19, 0),
                        LocalDateTime.of(2016, 9, 30, 18, 59)))
                .setOdd(new OutcomeOdd(3.5, LocalDateTime.of(2016, 9, 30, 19, 0)))
                .build();

        Bet betFootball1 = newBuilder()
                .setBetType(BetTypes.BETTING_FOR_WINNER)
                .setDescription("--")
                .setOutcome(outcome111)
                .setOutcome(outcome112)
                .setOutcome(outcome113)
                .build();

        footballSportEvent.getBets().add(betFootball1);

        Outcome outcome121 = Outcome.newBuilder()
                .setValue("0")
                .setOdd(new OutcomeOdd(1.75, LocalDateTime.of(2016, 9, 27, 19, 0)))
                .build();

        Outcome outcome122 = Outcome.newBuilder()
                .setValue("1")
                .setOdd(new OutcomeOdd(1.25, LocalDateTime.of(2016, 9, 27, 19, 0)))
                .build();

        Outcome outcome123 = Outcome.newBuilder()
                .setValue(" > 2")
                .setOdd(new OutcomeOdd(1.05, LocalDateTime.of(2016, 9, 27, 19, 0)))
                .build();

        Bet betFootball2 = newBuilder()
                .setBetType(BetTypes.BETTING_FOR_GOALS)
                .setDescription("--")
                .setOutcome(outcome121)
                .setOutcome(outcome122)
                .setOutcome(outcome123)
                .build();

        footballSportEvent.getBets().add(betFootball2);

        TennisSportEvent tennisSportEvent = TennisSportEvent.newBuilder()
                .setTitle("Rafael Nadal vs. Alexander Zverev, Indian Wells 4th Round")
                .setStartDate(LocalDateTime.of(2016, 8, 10, 19, 0))
                .setEndDate(LocalDateTime.of(2016, 8, 10, 22, 0))
                .build();

        Outcome outcome211 = Outcome.newBuilder()
                .setValue("Rafael Nadal")
                .setOdd(new OutcomeOdd(1.01, LocalDateTime.of(2016, 1, 1, 0, 0)))
                .build();

        Outcome outcome212 = Outcome.newBuilder()
                .setValue("Alexander Zverev")
                .setOdd(new OutcomeOdd(1.7, LocalDateTime.of(2016, 1, 1, 0, 0)))
                .build();

        Bet betTennis1 = newBuilder()
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
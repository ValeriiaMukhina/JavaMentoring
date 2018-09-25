package sports;

import org.junit.Before;
import org.junit.Test;
import sports.domain.betting.*;
import sports.domain.user.Player;
import sports.service.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Service
 */
public class ServiceTest {
    private List<SportEvent> sportEvents;
    private Outcome outcome;
    private Service service;
    private Player player;

    @Before
    public void generateTestData() {
        sportEvents = new ArrayList<>();
        FootballSportEvent footballSportEvent = FootballSportEvent.newBuilder()
                .setTitle("Test Sport Event")
                .setStartDate(LocalDateTime.of(2016, 10, 7, 19, 0))
                .setEndDate(LocalDateTime.of(2016, 10, 7, 21, 0))
                .build();
        outcome = Outcome.newBuilder()
                .setValue("test outcome")
                .setOdd(new OutcomeOdd(5.0, LocalDateTime.of(2016, 9, 30, 19, 0)))
                .build();
        Bet betFootball = Bet.newBuilder()
                .setBetType(BetTypes.BETTING_FOR_WINNER)
                .setDescription("--")
                .setOutcome(outcome)
                .build();
        footballSportEvent.getBets().add(betFootball);
        sportEvents.add(footballSportEvent);


        service = new Service();
        player = new Player();
        player.setBalance(1000);
        player.setCurrency(Currency.EUR);
    }

    @Test
    public void testCalculatePrize() {
        List<Wager> wagers = new ArrayList<>();
        List<Outcome> outcomes = new ArrayList<>();
        outcomes.add(outcome);
        sportEvents.get(0).setEventResult(new Result(outcomes));
        OutcomeOdd outcomeOdd = sportEvents.get(0).getBets().get(0).getOutcomes().get(0).getOutcomeOdd().get(0);
        Wager wager = new Wager(player, outcomeOdd, 10.0, player.getCurrency(), LocalDateTime.now(), State.UNPROCESSED);
        wagers.add(wager);
        assertEquals(50.0, service.calculatePrize(sportEvents, wagers), 0.1);
    }
}
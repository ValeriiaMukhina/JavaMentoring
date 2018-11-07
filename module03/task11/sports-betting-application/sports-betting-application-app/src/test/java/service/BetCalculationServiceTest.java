package sports;

import domain.betting.*;
import domain.user.Player;
import org.junit.Before;
import org.junit.Test;
import service.BetCalculationService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for BetCalculationService
 */
public class BetCalculationServiceTest {
    private List<SportEvent> sportEvents;
    private Outcome outcome;
    private BetCalculationService service;
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


        service = new BetCalculationService();
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
        List<Double> prizes = service.calculatedPrizes(outcomes, wagers);
        assertEquals(1, prizes.size());
        assertEquals(50.0, prizes.get(0), 0.1);
    }

    @Test
    public void testGetRealOutcomes() {
        List<Wager> wagers = new ArrayList<>();
        List<Outcome> outcomes = new ArrayList<>();
        outcomes.add(outcome);
        sportEvents.get(0).setEventResult(new Result(outcomes));
        OutcomeOdd outcomeOdd = sportEvents.get(0).getBets().get(0).getOutcomes().get(0).getOutcomeOdd().get(0);
        Wager wager = new Wager(player, outcomeOdd, 10.0, player.getCurrency(), LocalDateTime.now(), State.UNPROCESSED);
        wagers.add(wager);
        service.getRealOutcomes(sportEvents);
        assertEquals(1, service.getRealOutcomes(sportEvents).size());
        assertTrue(service.getRealOutcomes(sportEvents).contains(outcome));
    }

    @Test
    public void testListAllBets() {
        List<PossibleBetDescription> expected = new ArrayList<>();
        PossibleBetDescription possibleBetDescription =
                new PossibleBetDescription(1, sportEvents.get(0), sportEvents.get(0).getBets().get(0), outcome, outcome.getOutcomeOdd().get(0) );
        expected.add(possibleBetDescription);
        assertEquals(expected, service.listAllBets(sportEvents));
    }

    @Test
    public void testGenerateResults() {
        service.generateResults(sportEvents);
        assertNotNull(sportEvents.get(0).getEventResult());
    }

    @Test
    public void testGetPossibleBetDescriptionByIndex() {
        List<PossibleBetDescription> descriptions = new ArrayList<>();
        PossibleBetDescription possibleBetDescription =
                new PossibleBetDescription(1, sportEvents.get(0), sportEvents.get(0).getBets().get(0), outcome, outcome.getOutcomeOdd().get(0) );
        descriptions.add(possibleBetDescription);
        assertEquals(service.getPossibleBetDescriptionByIndex(descriptions,1), possibleBetDescription);
    }
}
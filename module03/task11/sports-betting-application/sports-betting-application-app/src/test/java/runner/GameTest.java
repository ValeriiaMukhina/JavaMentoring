package runner;

import domain.betting.*;
import domain.user.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import utils.ConsoleReader;
import utils.validation.OptionValidator;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest( { ConsoleReader.class })
public class GameTest {

    private Player player;
    private List<SportEvent> sportEvents;
    private Outcome outcome;
    private List<PossibleBetDescription> descriptions;


    @Before
    public void generateTestData() {
        player = new Player();
        player.setBalance(1000);
        player.setCurrency(Currency.EUR);
        player.setName("Test player");
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
        descriptions = new ArrayList<>();
        PossibleBetDescription possibleBetDescription =
                new PossibleBetDescription(1, sportEvents.get(0), sportEvents.get(0).getBets().get(0), outcome, outcome.getOutcomeOdd().get(0) );
        descriptions.add(possibleBetDescription);
        player = mock(Player.class);

        when(player.getName()).thenReturn("test");
        when(player.getCurrency()).thenReturn(Currency.EUR);
        when(player.getBalance()).thenReturn(10.0);
    }

    @Test
    public void verifyExitFromGame() {
        Game game = new Game(player,sportEvents);
        PowerMockito.mockStatic(ConsoleReader.class);
        when(ConsoleReader.read(new OptionValidator(anyInt()))).thenReturn("0");
        //When
        game.start();
        //Then
        Assert.assertTrue(game.getWagers().isEmpty());
    }

    @Test
    public void verifyNewWagersGenerated() {
        Game game = new Game(player,sportEvents);
        PowerMockito.mockStatic(ConsoleReader.class);
        when(ConsoleReader.read(new OptionValidator(anyInt()))).thenReturn("1", "0");
        //When
        game.start();
        //Then
        Assert.assertFalse(game.getWagers().isEmpty());
    }


}
package game;

import domain.betting.*;
import domain.user.Player;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import runner.Game;
import runner.GameDataGenerator;
import service.BetCalculationService;
import service.PossibleBetDescription;
import utils.Printer;
import utils.validation.CurrencyValidator;
import utils.validation.DateValidator;
import utils.validation.DoubleValidator;
import utils.validation.OptionValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@Configuration
public class TestConfig {

    @Mock
    GameDataGenerator gameDataGenerator;

    @Mock  private Player player;

    public TestConfig() {
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public GameDataGenerator getGameDataGenerator() {
        return gameDataGenerator;
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/gamemessages/game", "messages/user/user", "messages/validation/validation", "messages/printer/printer", "messages/service/bet");
        return messageSource;
    }

    @Bean
    public DoubleValidator getDoubleValidator() {
        return new DoubleValidator();
    }

    @Bean
    public CurrencyValidator getCurrencyValidator() {
        return new CurrencyValidator();
    }

    @Bean
    public DateValidator getDateValidator() {
        return new DateValidator();
    }

    @Bean
    public OptionValidator getOptionValidator() {
        return new OptionValidator();
    }

    @Bean
    public PossibleBetDescription getPossibleBetDescription() {
        return new PossibleBetDescription();
    }

    @Bean
    public Game getGame() {
        List<SportEvent> sportEvents = new ArrayList<>();
        FootballSportEvent footballSportEvent = FootballSportEvent.newBuilder()
                .setTitle("Test Sport Event")
                .setStartDate(LocalDateTime.of(2016, 10, 7, 19, 0))
                .setEndDate(LocalDateTime.of(2016, 10, 7, 21, 0))
                .build();
        Outcome  outcome = Outcome.newBuilder()
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
        when(gameDataGenerator.getUserFromConsole()).thenReturn(player);
        when(gameDataGenerator.createTestData()).thenReturn(sportEvents);
        return new Game();
    }

    @Bean
    public Printer getPrinter() {
        return new Printer();
    }

    @Bean
    public BetCalculationService getBetCalculationService() {
        return new BetCalculationService();
    }
}

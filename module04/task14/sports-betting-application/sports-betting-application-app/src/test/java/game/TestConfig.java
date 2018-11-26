package game;

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

@Configuration
public class TestConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/gamemessages/game", "messages/user/user", "messages/validation/validation", "messages/printer/printer", "messages/service/bet");
        return messageSource;
    }

    @Bean
    public GameDataGenerator getGameDataGenerator() {
        return new GameDataGenerator();
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

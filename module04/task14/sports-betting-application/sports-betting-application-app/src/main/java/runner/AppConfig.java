package runner;

import aspects.BetCalculationServiceAspect;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan("runner,service, utils, utils.validation, aspects")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/gamemessages/game", "messages/user/user",
                "messages/validation/validation", "messages/printer/printer", "messages/service/bet");
        return messageSource;
    }

    @Bean
    public BetCalculationServiceAspect betCalculationServiceAspect() {
        return new BetCalculationServiceAspect();
    }
}

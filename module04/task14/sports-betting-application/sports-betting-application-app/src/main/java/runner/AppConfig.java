package runner;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;

import aspects.BetCalculationServiceAspect;
/** Configuration spring class.
 * @author Valeriia Biruk
 * @version 1.0
 */
@Configuration
@ComponentScan("runner,service, utils, utils.validation, aspects")
@EnableAspectJAutoProxy
public class AppConfig {
    /** bean announced.
     * @return MessageSource
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/gamemessages/game", "messages/user/user",
                "messages/validation/validation", "messages/printer/printer", "messages/service/bet");
        return messageSource;
    }
    /** bean announced.
     * @return BetCalculationServiceAspect
     */
    @Bean
    public BetCalculationServiceAspect betCalculationServiceAspect() {
        return new BetCalculationServiceAspect();
    }
}

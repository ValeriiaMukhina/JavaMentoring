package runner;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Class to start application.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App() {
    }
    /**
     * main method to start application.
     *
     * @param args from console
     */

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        LOGGER.debug("Initializing application context \n");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        LOGGER.debug("Initialized application context");

        AppRunner runner = ctx.getBean(AppRunner.class);
        runner.start();
        ((AnnotationConfigApplicationContext) ctx).close();
    }
}

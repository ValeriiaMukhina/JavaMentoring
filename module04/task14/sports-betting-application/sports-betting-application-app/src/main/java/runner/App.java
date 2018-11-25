package runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * Class to start application.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    private App() {
    }
    /**
     * main method to start application.
     *
     * @param args from console
     */

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        logger.info("Initializing application context \n");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        logger.info("Initialized application context");

        AppRunner runner = ctx.getBean(AppRunner.class);
        runner.start();
    }
}

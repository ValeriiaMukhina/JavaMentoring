package utils;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import domain.betting.Outcome;
/**
 * Wrapper for system out.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Component
public final class Printer {

    private static String suffix;
    private static String prefix;

    private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);

    /**
     * System out println wrapper.
     *
     * @param message text to print on console.
     */
    public static void printToConsole(String message) {
        System.out.println(message);
    }

    /**
     * printer for outcomes of event.
     *
     * @param realOutcomes text to print on console.
     */
    public static void printRealOutcomes(List<Outcome> realOutcomes) {

        realOutcomes.forEach(outcome -> printToConsole(outcome + " " + suffix));
    }

    /**
     * printer for prizes of event.
     *
     * @param prizes text to print on console.
     */
    public static void printPrizes(List<Double> prizes) {
        prizes.forEach(prize -> printToConsole(prefix + " " + prize));
    }

    @Autowired
    public void setSuffix(MessageSource messageSource) {
        suffix = messageSource.getMessage("printer.suffix", new Object[]{},
                Locale.getDefault());
    }

    @Autowired
    public void setPrefix(MessageSource messageSource) {
        prefix = messageSource.getMessage("printer.prefix", new Object[]{},
                Locale.getDefault());
    }
}

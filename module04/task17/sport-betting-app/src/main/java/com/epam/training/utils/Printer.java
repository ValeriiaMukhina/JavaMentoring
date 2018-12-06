package com.epam.training.utils;

import com.epam.training.domain.betting.Outcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Wrapper for system out.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class Printer {

    private static Logger logger = LoggerFactory.getLogger(Printer.class);

    private Printer() {
    }

    /**
     * System out println wrapper.
     *
     * @param message text to print on console.
     */
    public static void printToConsole(String message) {
        logger.info("{} \n", message);
    }

    /**
     * printer for outcomes of event.
     *
     * @param realOutcomes text to print on console.
     */
    public static void printRealOutcomes(List<Outcome> realOutcomes) {
        realOutcomes.forEach(outcome -> printToConsole(outcome + " has won"));
    }

    /**
     * printer for prizes of event.
     *
     * @param prizes text to print on console.
     */
    public static void printPrizes(List<Double> prizes) {
        prizes.forEach(prize -> printToConsole("You have won " + prize));
    }
}

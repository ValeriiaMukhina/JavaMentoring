package utils;

import java.util.List;

import domain.betting.Outcome;
/**
 * Wrapper for system out.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class Printer {

    private Printer() {
    }

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

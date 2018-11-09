package utils;


import domain.betting.Outcome;

import java.util.List;

/**
 * Wrapper for system out.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class Printer {

    public static void printToConsole (String message) {
        System.out.println(message);
    }

    public static void printRealOutcomes(List<Outcome> realOutcomes) {
        realOutcomes.forEach(outcome -> printToConsole(outcome + " has won"));
    }

    public static void printPrizes(List<Double> prizes) {
        prizes.forEach(prize -> printToConsole("You have won " + prize));
    }
}

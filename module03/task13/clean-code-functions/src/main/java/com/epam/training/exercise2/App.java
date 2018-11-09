package com.epam.training.exercise2;
import static com.epam.training.exercise2.DateUtil.previousDay;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.exercise3.QueensPuzzle;
/**
 * Runner for exercise 2.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
final class App {

    private static Logger logger = LoggerFactory.getLogger(QueensPuzzle.class);

    private App() {
    }

    /**
     * main method.
     *
     * @param args arguments of main
     * @author Valeriia Biruk
     */
    public static void main(String[] args) {
        Date date = new Date();
        previousDay(date);
        logger.info("Date: {}", date);
        final int year = 2014;
        final int month = 10;
        final int day = 10;
        logger.info("New Date: {}", DateUtil.create(year, month, day));
    }
}

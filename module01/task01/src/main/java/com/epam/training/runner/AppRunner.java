package com.epam.training.runner;

import com.epam.training.domain.Outcomes;
import com.epam.training.service.TotoService;
import com.epam.training.utils.ConsoleReader;
import com.epam.training.utils.Printer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.epam.training.utils.InputParser.convertToCurrency;

public class AppRunner {

    public void start() {

        boolean exit = false;
        while (!exit) {
            Printer.printToConsole("Welcome");
            Printer.printToConsole("==============================");
            Printer.printToConsole("(1) Print the largest prize ever recorded");
            Printer.printToConsole("(2) calculate the distribution of the 1/2/X results of each round");
            Printer.printToConsole("(3) the hits and amount for the wager");
            Printer.printToConsole("(4) Exit");
            Printer.printToConsole("Choose an option: ");

            int choice = ConsoleReader.readOneIntegerFromConsole();
            TotoService service = new TotoService("toto_limited.csv");
            switch (choice) {
                case 1:
                    try {
                        BigDecimal prize = service.getLargestPrizeEverRecorded();
                        Printer.printToConsole(convertToCurrency(prize));
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    break;
                case 2:
                    service.calculateDistribution();
                    break;
                case 3:
                    Printer.printToConsole("Enter date in format 'yyyy.MM.dd.': ");
                    LocalDate localDate = ConsoleReader.readDate();
                    Printer.printToConsole("Enter predicted outcomes: ");
                    Outcomes[] predictedOutcomes = ConsoleReader.readOutcomes();
                    int numberOfHits = service.getNumberOfHits(localDate, predictedOutcomes);
                    BigDecimal prize = service.getYourPrize(localDate, numberOfHits);
                    String result =
                            "\n" +
                                    "Results: " +
                                    "Hits " +
                                     + numberOfHits +
                                    " Prize: " +
                                    convertToCurrency(prize)+
                                    "\n";
                    Printer.printToConsole(result);
                    break;
                case 4:
                    exit = true;
            }
        }
    }
}
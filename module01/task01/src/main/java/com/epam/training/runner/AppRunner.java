package com.epam.training.runner;

import com.epam.training.domain.Outcomes;
import com.epam.training.domain.Round;
import com.epam.training.service.TotoService;
import com.epam.training.utils.ConsoleReader;
import com.epam.training.utils.FileUtils;
import com.epam.training.utils.Printer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
            List<Round> rounds = FileUtils.readFromCsv("toto_limited.csv");
            TotoService service = new TotoService();
            switch (choice) {
                case 1:
                    try {
                        BigDecimal prize = service.getLargestPrizeForAllGames(rounds);
                        Printer.printToConsole("the largest prize ever recorded:");
                        Printer.printToConsole(convertToCurrency(prize));
                        Printer.printToConsole("==============================");
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    break;
                case 2:
                    service.printDistributions(rounds);
                    break;
                case 3:
                    Printer.printToConsole("Enter date in format 'yyyy.MM.dd.': ");
                    LocalDate gameDate = ConsoleReader.readDate();
                    Printer.printToConsole("Enter predicted outcomes (for example, 21xx11x221x122): ");
                    Outcomes[] predictedOutcomes = ConsoleReader.readOutcomes();
                    int hitsNumber = service.getHitsNumberForYourBet(rounds, gameDate, predictedOutcomes);
                    BigDecimal prize = service.getPrizeForYourBet(rounds, gameDate, predictedOutcomes);
                    String result =
                            "\n" +
                                    "Results: " +
                                    "Hits " +
                                     + hitsNumber +
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
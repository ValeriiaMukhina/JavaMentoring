package sports.runner;

import sports.domain.betting.Currency;
import sports.utils.ConsoleReader;
import sports.utils.Printer;

public class AppRunner {

    public void start() {
        boolean exit = false;
        while (!exit) {
            Printer.printToConsole("Welcome");
            Printer.printToConsole("==============================");
            Printer.printToConsole("Hi, what is your name?");


            String userName  = ConsoleReader.readFromConsole();
            Printer.printToConsole("What is your account number?");
            String accountNumber  = ConsoleReader.readFromConsole();
            Printer.printToConsole("How much money do you have (more than 0)?");
            Double balance = ConsoleReader.readOneDoubleFromConsole();
            Printer.printToConsole("What is your currency? (UAH, EUR or USD)");
            Currency currency = ConsoleReader.readCurrencyFromConsole();
            Printer.printToConsole("When were you born? eg.:1990-02-03");
      

        }
    }


}
package utils;

import java.util.Scanner;

import utils.validation.InputValidator;

/**
 * Reader from console.
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class ConsoleReader {

    private ConsoleReader() {
    }
    /**
     * Reader from console.
     * @author Valeriia Biruk
     * @return String
     * @param inputValidator interface
     * @version 1.0
     */
    public static String read(InputValidator inputValidator) {
        Scanner scan = new Scanner(System.in);
        Printer.printToConsole(inputValidator.message());
        boolean done = false;
        String str = null;
        while (!done) {
            str = scan.nextLine();
            if (inputValidator.isValid(str)) {
                done = true;
            } else {
                Printer.printToConsole(inputValidator.errorMessage());
            }
        }
        return str;
    }
}

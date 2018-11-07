package sports.utils;

import java.util.Scanner;
import sports.utils.validation.InputValidator;

/**
 * @author Valeriia Biruk
 * @version 1.0
 */
public class ConsoleReader {

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

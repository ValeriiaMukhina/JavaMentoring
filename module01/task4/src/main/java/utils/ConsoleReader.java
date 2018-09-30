package utils;

import domain.Expression;

import java.util.Scanner;

public class ConsoleReader {

    private static Scanner scan;

    public ConsoleReader() {
        scan = new Scanner(System.in);
    }

    public static Expression readExpression() {
        String line = readFromConsole();
        return new Expression(line);
    }

    public static void close() {
        scan.close();
    }

    public static String readFromConsole() {
        Scanner scan = new Scanner(System.in);
        Printer.printToConsole("Enter a string: ");
        return scan.nextLine();
    }
}
package utils;

import domain.Expression;
import exceptions.SyntaxException;

import java.util.Scanner;

public class ConsoleReader {

    private static Scanner scan;

    public ConsoleReader() {
        scan = new Scanner(System.in);
    }

    public static Expression readExpression() {
        String line = readFromConsole();
        if (line.matches(".*[a-zA-Z;~`#$_{}\\[\\]:\\\\;\"',\\.\\?]+.*")) {
            throw new SyntaxException("Invalid expression : " + line);
        }
        return Expression.of(line.replaceAll("\\s+",""));
    }

    public static void close() {
        scan.close();
    }

    public static String readFromConsole() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
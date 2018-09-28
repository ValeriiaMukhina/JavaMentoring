package utils;

import domain.Expression;

import java.util.Scanner;
import java.util.regex.Pattern;


public class ConsoleReader {

    private static Scanner scan;

    public ConsoleReader() {
        scan = new Scanner(System.in);
    }


    public static int[] readIntegersFromConsole(int length) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[length];
        for (int x = 0; x < arr.length; x++) {
            boolean done = false;
            while (!done) {
                if (length > 1) {
                    Printer.printToConsole("Enter a value " + (x + 1) + " :");
                }

                String str = scan.nextLine();
                int val;
                try {
                    val = Integer.parseInt(str);
                        arr[x] = val;
                        done = true;
                } catch (NumberFormatException e) {
                    Printer.printToConsole("Please enter a number value.");
                }

            }
        }
        return arr;
    }

    public static double[] readDoublesFromConsole(int length) {
        Scanner scan = new Scanner(System.in);

        double[] arr = new double[length];
        for (int x = 0; x < arr.length; x++) {
            boolean done = false;
            while (!done) {
                if (length > 1) {
                    Printer.printToConsole("Enter a value " + (x + 1) + " :");
                }

                String str = scan.nextLine();
                double val;
                try {
                    val = Double.parseDouble(str);
                    arr[x] = val;
                    done = true;
                } catch (NumberFormatException e) {
                    Printer.printToConsole("Please enter a number value.");
                }

            }
        }
        return arr;
    }

    public static int readOneIntegerFromConsole() {
        return readIntegersFromConsole(1)[0];
    }

    public static double readOneDoubleFromConsole() {
        return readDoublesFromConsole(1)[0];
    }

    public static boolean readYNFromConsole() {
        boolean done = false;
        boolean answer = false;
        while (!done) {

            String str = scan.nextLine();
            if (str.equals("Y")) {
                answer = true;
                done = true;
            } else if (str.equals("N")) {
                done = true;
            } else {
                Printer.printToConsole("Please enter a Y/N value.");
            }
        }
        return answer;
    }

    public static Expression readExpression() {
        String line = readFromConsole();
        return new Expression(line);
    }


    public void close() {
        scan.close();
    }


    public static String readFromConsole() {
        Scanner scan = new Scanner(System.in);
        Printer.printToConsole("Enter a string: ");
        return scan.nextLine();
    }

    public static int readOption(int maxValue) {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        int val = 0;

        while (!done) {
            String str = scan.nextLine();
            if ("q".equals(str)) {
                return val;
            }
            try {
                val = Integer.parseInt(str);
                if (val <= maxValue) {
                    done = true;
                } else {
                    Printer.printToConsole("Please enter a valid number from 1 to " + maxValue + " or q.");
                }
            } catch (NumberFormatException e) {
                Printer.printToConsole("Please enter a valid number from 1 to " + maxValue + " or q.");
            }
        }
        return val;
    }
}
package sports.utils;

import sports.domain.betting.Currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


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
                    System.out.println("Enter a value " + (x + 1) + " :");
                }

                String str = scan.nextLine();
                int val;
                try {
                    val = Integer.parseInt(str);
                    if (true) {
                        arr[x] = val;
                        done = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number value.");
                }

            }
        }
        // scan.close();
        return arr;
    }

    public static double[] readDoublesFromConsole(int length) {
        Scanner scan = new Scanner(System.in);

        double[] arr = new double[length];
        for (int x = 0; x < arr.length; x++) {
            boolean done = false;
            while (!done) {
                if (length > 1) {
                    System.out.println("Enter a value " + (x + 1) + " :");
                }

                String str = scan.nextLine();
                double val;
                try {
                    val = Double.parseDouble(str);
                        arr[x] = val;
                        done = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number value.");
                }

            }
        }
        // scan.close();
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
                answer = false;
                done = true;
            } else {
                System.out.println("Please enter a Y/N value.");
            }
        }
        return answer;
    }


    public static Currency readCurrencyFromConsole() {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        Currency answer = null;
        while (!done) {

            String str = scan.nextLine();
            if (str.equalsIgnoreCase("EUR")) {
                answer = Currency.EUR;
                done = true;
            } else if (str.equalsIgnoreCase("HUF")) {
                answer = Currency.HUF;
                done = true;
            } else if (str.equalsIgnoreCase("USD")) {
                answer = Currency.USD;
                done = true;
            } else {
                System.out.println("Please enter EUR/HUF/USD value.");
            }
        }
        return answer;
    }


    public void close() {
        scan.close();
    }



    public static String readFromConsole() {
        Scanner scan = new Scanner(System.in);
        //boolean done = false;

        System.out.println("Enter a string: ");
        String str = scan.nextLine();

        return str;
    }

    public static int readOption(int maxValue) {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        int val = 0;

        while (!done) {
            String str = scan.nextLine();
            if("q".equals(str)) {return val;}
            try {
                val = Integer.parseInt(str);
                if (val <= maxValue) {
                    done = true;
                }
                else {System.out.println("Please enter a valid number from 1 to " + maxValue + " or q.");}
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number from 1 to " + maxValue + " or q.");
            }
        }
        return val;
    }

    public static LocalDate readDate() {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        LocalDate localDate = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (!done) {
            String str = scan.nextLine();
            try {
                localDate = LocalDate.parse(str, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Please enter a valid date.");
            }
            if (localDate != null) {
                done = true;
            }
        }
        return localDate;
    }
}
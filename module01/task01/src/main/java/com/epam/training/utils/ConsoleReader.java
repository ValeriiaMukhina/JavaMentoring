package com.epam.training.utils;

import com.epam.training.domain.Outcomes;

import java.time.LocalDate;
import java.util.Scanner;

import static com.epam.training.utils.InputParser.parseLocalDate;
import static com.epam.training.utils.InputParser.parseOutcome;

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
                    if (verifyInput(val)) {
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

    public static int readOneIntegerFromConsole() {
        return readIntegersFromConsole(1)[0];
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

    public void close() {
        scan.close();
    }

    public static boolean verifyInput(double val) {
        if (val < 1 || val > 4) {
            System.out.println("Error : Choose an option between 1 and 4");
            return false;
        }
        return true;
    }


    public static String readFromConsole() {
        //Scanner scan = new Scanner(System.in);
        //boolean done = false;

        System.out.println("Enter a string: ");
        String str = scan.nextLine();

        return str;
    }

    public static LocalDate readDate() {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        LocalDate localDate = null;
        while (!done) {
            String str = scan.nextLine();
            localDate = parseLocalDate(str);
            if (localDate != null) {
                done = true;
            } else {
                System.out.println("Please enter a valid date.");
            }
        }
        return localDate;
    }

    public static Outcomes[] readOutcomes() {
        Scanner scan = new Scanner(System.in);
        Outcomes[] outcomes = new Outcomes[14];
        boolean done = false;
        while (!done) {
            String str = scan.nextLine();
            if (str.length() != 14) {
                System.out.println("Please enter 14 outcomes:");
            }
            for (int i = 0; i < outcomes.length; i++) {
                outcomes[i] = parseOutcome(str.substring(i, i + 1));
            }
            done = true;
        }
        return outcomes;
    }
}
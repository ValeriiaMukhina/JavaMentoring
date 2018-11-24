package utils;

import domain.betting.Outcome;
import domain.betting.OutcomeOdd;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PrinterTest {

    @Test
    public void printTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        String expectedValueToPrint = "test";
        Printer.printToConsole("test");

        Assert.assertEquals(expectedValueToPrint.trim(), outContent.toString().trim());
    }

    @Test
    public void printPrizesTest() {
        List<Double> prizes = Arrays.asList(4.0);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        String expectedValueToPrint = "You have won " + String.valueOf(4.0);
        Printer.printPrizes(prizes);

        Assert.assertEquals(expectedValueToPrint.trim(), outContent.toString().trim());
    }

    @Test
    public void printRealOutcomesTest() {
        Outcome outcome = Outcome.newBuilder()
                .setValue("test outcome2")
                .setOdd(new OutcomeOdd(5.0, LocalDateTime.of(2016, 9, 30, 19, 0),LocalDateTime.of(2018, 9, 30, 19, 0)))
                .build();
        List<Outcome> realOutcomes = Arrays.asList(outcome);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent stream.

        String expectedValueToPrint = outcome.toString() + " has won";
        Printer.printRealOutcomes(realOutcomes);

        Assert.assertEquals(expectedValueToPrint.trim(), outContent.toString().trim());
    }
}
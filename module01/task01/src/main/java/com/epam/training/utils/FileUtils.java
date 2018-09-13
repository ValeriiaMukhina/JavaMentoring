package com.epam.training.utils;

import com.epam.training.domain.Hit;
import com.epam.training.domain.Outcomes;
import com.epam.training.domain.Round;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.epam.training.utils.InputParser.*;


public class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static List<Round> readFromCsv(String fileName) {

        List<Round> linesFromCsv = new ArrayList<>();
        File file = getFile(fileName);

        CsvSchema schema = CsvSchema.builder()
                .addColumn("year")
                .addColumn("week")
                .addColumn("round")
                .addColumn("date")
                .addColumn("Number of games with 14 hits")
                .addColumn("Prize for 14 hits")
                .addColumn("Number of games with 13 hits")
                .addColumn("Prize for 13 hits")
                .addColumn("Number of games with 12 hits")
                .addColumn("Prize for 12 hits")
                .addColumn("Number of games with 11 hits")
                .addColumn("Prize for 11 hits")
                .addColumn("Number of games with 10 hits")
                .addColumn("Prize for 10 hits")
                .addColumn("Result 1")
                .addColumn("Result 2")
                .addColumn("Result 3")
                .addColumn("Result 4")
                .addColumn("Result 5")
                .addColumn("Result 6")
                .addColumn("Result 7")
                .addColumn("Result 8")
                .addColumn("Result 9")
                .addColumn("Result 10")
                .addColumn("Result 11")
                .addColumn("Result 12")
                .addColumn("Result 13")
                .addColumn("Result 14")
                .build();
        schema = schema.withColumnSeparator(';');
        CsvMapper mapper = new CsvMapper();


        ObjectReader oReader = mapper.readerFor(Map.class).with(schema);

        try (Reader reader = new FileReader(file)) {
            MappingIterator<Map<String, String>> mi = oReader.readValues(reader);
            while (mi.hasNext()) {
                Round round = new Round();
                Map<String, String> map = mi.next();
                round.setYear(parseYear(map.get("year")));
                round.setWeek(parseWeek(map.get("week")));
                round.setRound(parseInteger(map.get("round")));
                round.setDate(parseLocalDate(map.get("date")));
                Hit hit14 = new Hit(14, parseInteger(map.get("Number of games with 14 hits")), parseCurrencyToBigDecimal(map.get("Prize for 14 hits")));
                Hit hit13 = new Hit(13, parseInteger(map.get("Number of games with 13 hits")), parseCurrencyToBigDecimal(map.get("Prize for 13 hits")));
                Hit hit12 = new Hit(12, parseInteger(map.get("Number of games with 12 hits")), parseCurrencyToBigDecimal(map.get("Prize for 12 hits")));
                Hit hit11 = new Hit(11, parseInteger(map.get("Number of games with 11 hits")), parseCurrencyToBigDecimal(map.get("Prize for 11 hits")));
                Hit hit10 = new Hit(10, parseInteger(map.get("Number of games with 10 hits")), parseCurrencyToBigDecimal(map.get("Prize for 10 hits")));
                round.setHits(new Hit[]{hit14, hit13, hit12, hit11, hit10});
                Outcomes outcome1 = parseOutcome(map.get("Result 1"));
                Outcomes outcome2 = parseOutcome(map.get("Result 2"));
                Outcomes outcome3 = parseOutcome(map.get("Result 3"));
                Outcomes outcome4 = parseOutcome(map.get("Result 4"));
                Outcomes outcome5 = parseOutcome(map.get("Result 5"));
                Outcomes outcome6 = parseOutcome(map.get("Result 6"));
                Outcomes outcome7 = parseOutcome(map.get("Result 7"));
                Outcomes outcome8 = parseOutcome(map.get("Result 8"));
                Outcomes outcome9 = parseOutcome(map.get("Result 9"));
                Outcomes outcome10 = parseOutcome(map.get("Result 10"));
                Outcomes outcome11 = parseOutcome(map.get("Result 11"));
                Outcomes outcome12 = parseOutcome(map.get("Result 12"));
                Outcomes outcome13 = parseOutcome(map.get("Result 13"));
                Outcomes outcome14 = parseOutcome(map.get("Result 14"));
                Outcomes[] outcomes = new Outcomes[]{
                        outcome1,
                        outcome2,
                        outcome3,
                        outcome4,
                        outcome5,
                        outcome6,
                        outcome7,
                        outcome8,
                        outcome9,
                        outcome10,
                        outcome11,
                        outcome12,
                        outcome13,
                        outcome14
                };
                round.setOutcomes(outcomes);
                linesFromCsv.add(round);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesFromCsv;
    }

    private static File getFile(String fileName) {
        //  String FILE_NAME = "toto_limited.csv";
        return new File(FileUtils.class.getClassLoader().getResource(fileName).getFile());
    }
}
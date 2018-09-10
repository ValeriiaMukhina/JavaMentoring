package com.epam.training;

import com.epam.training.domain.Hit;
import com.epam.training.domain.Round;
import com.epam.training.runner.AppRunner;
import com.epam.training.service.TotoService;
import com.epam.training.utils.FileReaderHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Round> linesFromCsv = new ArrayList<>();

           linesFromCsv = FileReaderHelper.readFromCsv("toto_limited.csv");


        System.out.println( linesFromCsv.get(0).getHits()[0].getPrice());
        for(Round round : linesFromCsv) {
            for(Hit hit : round.getHits()) {
                System.out.println(hit);
            }

        }

        try {
            TotoService service = new TotoService("toto_limited.csv");
            service.setRounds(linesFromCsv);

            System.out.println(service.getLargestPrizeEverRecorded());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        new AppRunner().start();
    }
}

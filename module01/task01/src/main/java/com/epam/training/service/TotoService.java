package com.epam.training.service;

import com.epam.training.domain.Distribution;
import com.epam.training.domain.Hit;
import com.epam.training.domain.Outcomes;
import com.epam.training.domain.Round;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TotoService {

    public BigDecimal getLargestPrizeEverRecorded(List<Round> rounds) throws Throwable {

        Optional largestPrize = rounds.stream()
                .flatMap(x -> Arrays.stream(x.getHits()))
                .map(Hit::getPrice)
                .max(Comparator.naturalOrder());
        return (BigDecimal) largestPrize.orElseThrow(IllegalArgumentException::new);
    }

    public int getNumberOfHits(List<Round> rounds, LocalDate dateOfGame, Outcomes[] supposedOutcomes) {
        int numberOfHits = 0;
        Round round = getRoundOnDate(rounds, dateOfGame);
        Outcomes[] actualOutcomes = round.getOutcomes();
        for (int i = 0; i < supposedOutcomes.length; i++) {
            if (supposedOutcomes[i].equals(actualOutcomes[i])) numberOfHits++;
        }
        return numberOfHits;
    }

    public BigDecimal getYourPrize(List<Round> rounds, LocalDate dateOfGame, int numberOfHits) {
        Round round = getRoundOnDate(rounds, dateOfGame);
        Hit[] hits = round.getHits();
        Hit actualHit = Arrays.stream(hits).filter(hit -> hit.getNumberOfHits() == numberOfHits).findFirst().
                orElseThrow(IllegalArgumentException::new);
        return actualHit.getPrice();
    }


    public Round getRoundOnDate(List<Round> rounds, LocalDate dateOfGame) {
        return rounds.stream()
                .filter(round -> round.getDate().equals(dateOfGame))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No data found for specified date"));
    }

    public void calculateDistribution(List<Round> rounds) {
        rounds.stream().map(Distribution::new).forEach(System.out::println);
    }
}
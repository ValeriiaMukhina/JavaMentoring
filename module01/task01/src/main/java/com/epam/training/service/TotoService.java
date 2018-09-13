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

    public BigDecimal getLargestPrizeForAllGames(List<Round> rounds) throws Throwable {
        Optional largestPrize = rounds.stream()
                .flatMap(x -> Arrays.stream(x.getHits()))
                .map(Hit::getPrice)
                .max(Comparator.naturalOrder());
        return (BigDecimal) largestPrize.orElseThrow(IllegalArgumentException::new);
    }

    public int getHitsNumber(Round round, Outcomes[] supposedOutcomes) {
        int hitsNumber = 0;
        Outcomes[] actualOutcomes = round.getOutcomes();
        for (int i = 0; i < supposedOutcomes.length; i++) {
            if (supposedOutcomes[i].equals(actualOutcomes[i])) hitsNumber++;
        }
        return hitsNumber;
    }

    public int getHitsNumberForYourBet(List<Round> rounds, LocalDate dateOfGame, Outcomes[] supposedOutcomes) {
        Round round = getRoundOnDate(rounds, dateOfGame);
        return getHitsNumber(round,supposedOutcomes);
    }

    public BigDecimal getPrizeForYourBet(List<Round> rounds, LocalDate dateOfGame, Outcomes[] supposedOutcomes) {
        Round round = getRoundOnDate(rounds, dateOfGame);
        int hitsNumber = getHitsNumber(round,supposedOutcomes);
        return getPrizeForHitsNumber(round, hitsNumber);
    }

    public BigDecimal getPrizeForHitsNumber(Round round, int hitsNumber) {
        Hit[] hits = round.getHits();
        Hit actualHit = Arrays.stream(hits).filter(hit -> hit.getNumberOfHits() == hitsNumber).findFirst().
                orElseThrow(IllegalArgumentException::new);
        return actualHit.getPrice();
    }


    public Round getRoundOnDate(List<Round> rounds, LocalDate dateOfGame) {
        return rounds.stream()
                .filter(round -> round.getDate().equals(dateOfGame))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No data found for specified date"));
    }

    public void printDistributions(List<Round> rounds) {
        rounds.stream().map(Distribution::new).forEach(System.out::println);
    }

    public Distribution getDistribution(Round round) {
        return new Distribution(round);
    }
}
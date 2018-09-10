package com.epam.training.service;

import com.epam.training.domain.Distribution;
import com.epam.training.domain.Hit;
import com.epam.training.domain.Outcomes;
import com.epam.training.domain.Round;
import com.epam.training.utils.FileReaderHelper;
import com.epam.training.utils.InputParser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TotoService {

    private List<Round> rounds;

    public TotoService(String fileName) {
        this.rounds = FileReaderHelper.readFromCsv(fileName);
    }

    public BigDecimal getLargestPrizeEverRecorded() throws Throwable {

        Optional largestPrize = rounds.stream()
                .flatMap(x -> Arrays.stream(x.getHits()))
                .map(Hit::getPrice)
                .max(Comparator.naturalOrder());
        return (BigDecimal) largestPrize.orElseThrow(() -> new RuntimeException(""));
    }

    public int getNumberOfHits(LocalDate dateOfGame, Outcomes[] supposedOutcomes) {
        int numberOfHits = 0;
        Round round = getRoundOnDate(dateOfGame);
        Outcomes[] actualOutcomes = round.getOutcomes();
        for (int i = 0; i < supposedOutcomes.length; i++) {
            if (supposedOutcomes[i].equals(actualOutcomes[i])) numberOfHits++;
        }
        return numberOfHits;
    }

    public BigDecimal getYourPrize(LocalDate dateOfGame, int numberOfHits) {
        Round round = getRoundOnDate(dateOfGame);
        Hit[] hits = round.getHits();
        Hit actualHit = Arrays.stream(hits).filter(hit -> hit.getNumberOfHits() == numberOfHits).findFirst().
                orElseThrow(() -> new RuntimeException(""));
        return actualHit.getPrice();
    }


    public Round getRoundOnDate(LocalDate dateOfGame) {
        return rounds.stream()
                .filter(round -> round.getDate().equals(dateOfGame))
                .findFirst().orElseThrow(() -> new RuntimeException(""));
    }

    public void calculateDistribution() {
       rounds.stream().map(Distribution::new).forEach(System.out::println);
    }


    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}

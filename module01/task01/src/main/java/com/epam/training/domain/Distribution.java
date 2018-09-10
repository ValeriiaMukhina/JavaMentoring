package com.epam.training.domain;

import java.util.Arrays;

import static com.epam.training.utils.InputParser.formatDoubles;

public class Distribution {

    Round round;

    long firstTeamWinsNumber;
    long secondTeamWinsNumber;
    long drawsNumber;
    int total;

    private double firstTeamWinsPercentage;
    private double secondTeamWinsPercentage;
    private double drawPercentage;

    public Distribution(Round round) {
        this.round = round;
        calculateAmounts();
        calculatePercentages();
    }

    private void calculatePercentages() {
        firstTeamWinsPercentage = getPercentage(firstTeamWinsNumber, total);
        secondTeamWinsPercentage = getPercentage(secondTeamWinsNumber, total);
        drawPercentage = 100 - firstTeamWinsPercentage - secondTeamWinsPercentage;
    }

    private double getPercentage(long value, int total) {
        return (double) value / (double) total * 100;
    }

    private void calculateAmounts() {
        Outcomes[] outcomes = round.getOutcomes();
        firstTeamWinsNumber = Arrays.stream(outcomes).filter(Outcomes.FIRST_TEAM_WIN::equals).count();
        secondTeamWinsNumber = Arrays.stream(outcomes).filter(Outcomes.SECOND_TEAM_WIN::equals).count();
        drawsNumber = Arrays.stream(outcomes).filter(Outcomes.DRAW::equals).count();
        total = outcomes.length;
    }

    public double getFirstTeamWinsPercentage() {
        return firstTeamWinsPercentage;
    }

    public double getSecondTeamWinsPercentage() {
        return secondTeamWinsPercentage;
    }

    public double getDrawPercentage() {
        return drawPercentage;
    }

    @Override
    public String toString() {
        String builder =
                "\n" +
                "team #1 won: " +
                        formatDoubles(getFirstTeamWinsPercentage()) +
                "% team #2 won: " +
                        formatDoubles(getSecondTeamWinsPercentage())  +
                "% draw: " +
                        formatDoubles(getDrawPercentage())+
                "%\n";
        return builder;
    }
}
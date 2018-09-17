package com.epam.training.domain;

import java.util.Arrays;
import java.util.Objects;

import static com.epam.training.utils.InputParser.formatDoubles;

public class Distribution {

    private Round round;

    private long firstTeamWinsNumber;
    private long secondTeamWinsNumber;
    private long drawsNumber;
    private int totalNumberOfGames;

    private double firstTeamWinsPercentage;
    private double secondTeamWinsPercentage;
    private double drawPercentage;

    public Distribution(Round round) {
        this.round = round;
        calculateWinsNumberForEachTeam();
        calculatePercentages();
    }

    private void calculatePercentages() {
        firstTeamWinsPercentage = getPercentage(firstTeamWinsNumber, totalNumberOfGames);
        secondTeamWinsPercentage = getPercentage(secondTeamWinsNumber, totalNumberOfGames);
        drawPercentage = 1 - firstTeamWinsPercentage - secondTeamWinsPercentage;
    }

    private double getPercentage(long value, int total) {
        return Math.round(((double) value / (double) total) * 10000.0) / 10000.0;
    }

    private void calculateWinsNumberForEachTeam() {
        Outcomes[] outcomes = round.getOutcomes();
        firstTeamWinsNumber = Arrays.stream(outcomes).filter(Outcomes.FIRST_TEAM_WIN::equals).count();
        secondTeamWinsNumber = Arrays.stream(outcomes).filter(Outcomes.SECOND_TEAM_WIN::equals).count();
        drawsNumber = Arrays.stream(outcomes).filter(Outcomes.DRAW::equals).count();
        totalNumberOfGames = outcomes.length;
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
        return "\n" +
        "team #1 won: " +
                formatDoubles(getFirstTeamWinsPercentage() * 100)  +
        "% team #2 won: " +
                formatDoubles(getSecondTeamWinsPercentage() * 100)  +
        "% draw: " +
                formatDoubles(getDrawPercentage() * 100)+
        "%\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distribution that = (Distribution) o;
        return firstTeamWinsNumber == that.firstTeamWinsNumber &&
                secondTeamWinsNumber == that.secondTeamWinsNumber &&
                drawsNumber == that.drawsNumber &&
                totalNumberOfGames == that.totalNumberOfGames &&
                Double.compare(that.firstTeamWinsPercentage, firstTeamWinsPercentage) == 0 &&
                Double.compare(that.secondTeamWinsPercentage, secondTeamWinsPercentage) == 0 &&
                Double.compare(that.drawPercentage, drawPercentage) == 0 &&
                Objects.equals(round, that.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, firstTeamWinsNumber, secondTeamWinsNumber, drawsNumber, totalNumberOfGames, firstTeamWinsPercentage, secondTeamWinsPercentage, drawPercentage);
    }
}
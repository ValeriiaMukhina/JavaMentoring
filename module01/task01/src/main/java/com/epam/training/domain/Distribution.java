package com.epam.training.domain;

import java.util.Arrays;

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
        return (double) value / (double) total;
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
        if (!(o instanceof Distribution)) return false;

        Distribution that = (Distribution) o;

        if (firstTeamWinsNumber != that.firstTeamWinsNumber) return false;
        if (secondTeamWinsNumber != that.secondTeamWinsNumber) return false;
        if (drawsNumber != that.drawsNumber) return false;
        if (totalNumberOfGames != that.totalNumberOfGames) return false;
        if (Double.compare(that.getFirstTeamWinsPercentage(), getFirstTeamWinsPercentage()) != 0) return false;
        if (Double.compare(that.getSecondTeamWinsPercentage(), getSecondTeamWinsPercentage()) != 0) return false;
        if (Double.compare(that.getDrawPercentage(), getDrawPercentage()) != 0) return false;
        return round.equals(that.round);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = round.hashCode();
        result = 31 * result + (int) (firstTeamWinsNumber ^ (firstTeamWinsNumber >>> 32));
        result = 31 * result + (int) (secondTeamWinsNumber ^ (secondTeamWinsNumber >>> 32));
        result = 31 * result + (int) (drawsNumber ^ (drawsNumber >>> 32));
        result = 31 * result + totalNumberOfGames;
        temp = Double.doubleToLongBits(getFirstTeamWinsPercentage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSecondTeamWinsPercentage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDrawPercentage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
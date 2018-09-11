package com.epam.training.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;

public class Round {
    private String year;
    private String week;
    private int round;
    private LocalDate date;
    private Hit[] hits = new Hit[5];
    private Outcomes[] outcomes;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Hit[] getHits() {
        return hits;
    }

    public void setHits(Hit[] hits) {
        this.hits = hits;
    }

    public Outcomes[] getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Outcomes[] outcomes) {
        this.outcomes = outcomes;
    }

    @Override
    public String toString() {
        return "Round{" +
                "year='" + year + '\'' +
                ", week='" + week + '\'' +
                ", round=" + round +
                ", date=" + date +
                ", hits=" + Arrays.toString(hits) +
                ", outcomes=" + Arrays.toString(outcomes) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Round)) return false;

        Round round1 = (Round) o;

        if (getRound() != round1.getRound()) return false;
        if (getYear() != null ? !getYear().equals(round1.getYear()) : round1.getYear() != null) return false;
        if (getWeek() != null ? !getWeek().equals(round1.getWeek()) : round1.getWeek() != null) return false;
        if (getDate() != null ? !getDate().equals(round1.getDate()) : round1.getDate() != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getHits(), round1.getHits())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getOutcomes(), round1.getOutcomes());
    }

    @Override
    public int hashCode() {
        int result = getYear() != null ? getYear().hashCode() : 0;
        result = 31 * result + (getWeek() != null ? getWeek().hashCode() : 0);
        result = 31 * result + getRound();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getHits());
        result = 31 * result + Arrays.hashCode(getOutcomes());
        return result;
    }
}

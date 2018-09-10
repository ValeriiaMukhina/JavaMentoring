package com.epam.training.domain;


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
}

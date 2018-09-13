package com.epam.training.domain;

public enum Outcomes {

    FIRST_TEAM_WIN("1"),
    SECOND_TEAM_WIN("2"),
    DRAW("X");

    private String notation;

    Outcomes(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

}

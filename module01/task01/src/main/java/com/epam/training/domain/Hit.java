package com.epam.training.domain;

import java.math.BigDecimal;

public class Hit {
    private int numberOfHits;
    private int numberOfGames;
    private BigDecimal price;

    public Hit(int numberOfHits, int numberOfGames, BigDecimal price) {
        this.numberOfHits = numberOfHits;
        this.numberOfGames = numberOfGames;
        this.price = price;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hit{" +
                "numberOfHits=" + numberOfHits +
                ", numberOfGames=" + numberOfGames +
                ", price=" + price +
                '}';
    }
}

package com.epam.training.domain.betting;


import com.epam.training.domain.user.Player;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * wage class.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class Wager {

    private Player player;
    private OutcomeOdd outcomeOdd;
    private Double amount;
    private Currency currency;
    private LocalDateTime timestamp;
    private State state;
    private Boolean isWin;

    public Wager(Player player, OutcomeOdd outcomeOdd, double wage, LocalDateTime timestamp) {
        this.player = player;
        this.outcomeOdd = outcomeOdd;
        this.amount = wage;
        this.currency = player.getCurrency();
        this.timestamp = timestamp;
        this.state = State.UNPROCESSED;
    }

    public Player getPlayer() {
        return player;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public Double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public State getState() {
        return state;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }
    /**
     * sets wage status to win or not.
     *
     * @param outcomeOdd list of outcomes to process
     * @return isWin
     */
    public boolean processWin(List<OutcomeOdd> outcomeOdd) {
        isWin = false;
        Optional<OutcomeOdd> win = outcomeOdd.stream().filter(odd -> odd.equals(this.getOutcomeOdd())).findFirst();
        if (win.isPresent()) {
            isWin = true;
            state = State.PROCESSED;
            amount = amount * win.get().getOddValue();
        }
        return isWin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wager)) {
            return false;
        }
        Wager wager = (Wager) o;
        return Objects.equals(getPlayer(), wager.getPlayer())
                && Objects.equals(getOutcomeOdd(), wager.getOutcomeOdd())
                && Objects.equals(getAmount(), wager.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, outcomeOdd, amount, currency, timestamp, state, isWin);
    }

    @Override
    public String toString() {
        return "Wager{"
                + "player=" + player
                + ", outcomeOdd=" + outcomeOdd
                + ", amount=" + amount
                + ", currency=" + currency
                + ", timestamp=" + timestamp
                + ", state=" + state
                + ", isWin=" + isWin
                + '}';
    }
}

package sports.domain.betting;


import sports.domain.user.Player;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Wager {

    private Player player;
    private OutcomeOdd outcomeOdd;
    private Double amount;
    private Currency currency;
    private LocalDateTime timestamp;
    private State state;
    private Boolean isWin;

    public Wager(Player player, OutcomeOdd outcomeOdd, Double amount, Currency currency, LocalDateTime timestamp, State state) {
        this.player = player;
        this.outcomeOdd = outcomeOdd;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
        this.state = state;
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

    public boolean processWin(List<OutcomeOdd> outcomeOdd) {
        isWin = false;
        Optional<OutcomeOdd> win = outcomeOdd.stream().filter(odd -> odd.equals(this.getOutcomeOdd())).findFirst();
        if(win.isPresent()) {
            isWin = true;
            state = State.PROCESSED;
            amount = amount * win.get().getOddValue();
        }
        return isWin;
    }
}

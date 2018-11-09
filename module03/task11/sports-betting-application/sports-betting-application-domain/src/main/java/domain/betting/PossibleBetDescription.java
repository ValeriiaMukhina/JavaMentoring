package domain.betting;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class PossibleBetDescription {

    private String description;
    private int numberOfBet;
    private SportEvent sportEvent;
    private Bet bet;
    private Outcome outcome;
    private OutcomeOdd outcomeOdd;

    public PossibleBetDescription(int numberOfBet, SportEvent sportEvent, Bet bet, Outcome outcome, OutcomeOdd outcomeOdd) {
        this.sportEvent = sportEvent;
        this.bet = bet;
        this.outcome = outcome;
        this.outcomeOdd = outcomeOdd;
        this.numberOfBet = numberOfBet;
        StringBuilder descriptionBuilder = new StringBuilder(numberOfBet + ": Bet on ")
                .append(sportEvent.getTitle())
                .append(" sport event, ")
                .append(bet.getDescription());
        if (BetTypes.BETTING_FOR_WINNER.equals(bet.getType())) {
            descriptionBuilder.append("The winner will be ");
        } else if (BetTypes.BETTING_FOR_PLAYERS_SCORE.equals(bet.getType())) {
            descriptionBuilder.append("The player will score ");
        } else if (BetTypes.BETTING_FOR_GOALS.equals(bet.getType())) {
            descriptionBuilder.append("The number of scored goals will be ");
        }
        descriptionBuilder.append(outcome.getValue())
                .append(". The odd on this is ")
                .append(outcomeOdd.getOddValue())
                .append(", valid from ")
                .append(outcomeOdd.getValidFrom().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM")));
        if (outcomeOdd.getValidTo() != null) {
            descriptionBuilder.append(" to ")
                    .append(outcomeOdd.getValidTo().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM")));
        }
        description = descriptionBuilder.toString();
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    @Override
    public String toString() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PossibleBetDescription that = (PossibleBetDescription) o;
        return numberOfBet == that.numberOfBet &&
                Objects.equals(description, that.description) &&
                Objects.equals(sportEvent, that.sportEvent) &&
                Objects.equals(bet, that.bet) &&
                Objects.equals(outcome, that.outcome) &&
                Objects.equals(outcomeOdd, that.outcomeOdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, numberOfBet, sportEvent, bet, outcome, outcomeOdd);
    }
}

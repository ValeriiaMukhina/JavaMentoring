package com.epam.trainings.domain.betting;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * pretty wrapper for all bet information to print.
 *
 * @author Valeriia Biruk
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
        this.sportEvent = checkNotNull(sportEvent);
        this.bet = checkNotNull(bet);
        this.outcome = checkNotNull(outcome);
        this.outcomeOdd = checkNotNull(outcomeOdd);
        checkArgument(numberOfBet > 0, "Argument was %s but expected nonnegative", numberOfBet);
        this.numberOfBet = numberOfBet;
        buildDescription();
    }

    private void buildDescription() {
        StringBuilder descriptionBuilder = new StringBuilder(numberOfBet + ": Bet on ")
                .append(sportEvent.getTitle())
                .append(" sport event, ")
                .append(bet.getDescription());
        descriptionBuilder.append(adjustDescriptionByBettingType(bet));
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

    private String adjustDescriptionByBettingType(Bet bet) {
        String result = null;
        if (BetTypes.BETTING_FOR_WINNER.equals(bet.getType())) {
            result = "The winner will be ";
        } else if (BetTypes.BETTING_FOR_PLAYERS_SCORE.equals(bet.getType())) {
            result = "The player will score ";
        } else if (BetTypes.BETTING_FOR_GOALS.equals(bet.getType())) {
            result = "The number of scored goals will be ";
        }
        return result;
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
        if (!(o instanceof PossibleBetDescription)) {
            return false;
        }
        PossibleBetDescription that = (PossibleBetDescription) o;
        return numberOfBet == that.numberOfBet
                && Objects.equals(description, that.description)
                && Objects.equals(sportEvent, that.sportEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, numberOfBet, sportEvent, bet, outcome, outcomeOdd);
    }
}

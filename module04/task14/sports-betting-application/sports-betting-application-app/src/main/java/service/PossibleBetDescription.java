package service;

import domain.betting.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 * pretty wrapper for all bet information to print.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Service
public class PossibleBetDescription {

    @Autowired
    MessageSource messageSource;

    private String description;
    private int numberOfBet;
    private SportEvent sportEvent;
    private Bet bet;
    private Outcome outcome;
    private OutcomeOdd outcomeOdd;

    public PossibleBetDescription init(int numberOfBet, SportEvent sportEvent, Bet bet, Outcome outcome, OutcomeOdd outcomeOdd) {
        this.sportEvent = checkNotNull(sportEvent);
        this.bet = checkNotNull(bet);
        this.outcome = checkNotNull(outcome);
        this.outcomeOdd = checkNotNull(outcomeOdd);
        checkArgument(numberOfBet > 0, "Argument was %s but expected nonnegative", numberOfBet);
        this.numberOfBet = numberOfBet;
        buildDescription();
        return this;
    }

    private void buildDescription() {
        String oddSuffix = messageSource.getMessage("bet.oddSuffix", new Object[]{},
                Locale.getDefault());
        StringBuilder descriptionBuilder = new StringBuilder(numberOfBet + ": Bet on ")
                .append(sportEvent.getTitle())
                .append(" sport event, ")
                .append(bet.getDescription());
        descriptionBuilder.append(adjustDescriptionByBettingType(bet));
        descriptionBuilder.append(outcome.getValue())
                .append(oddSuffix)
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
            result = messageSource.getMessage("bet.winner", new Object[]{},
                    Locale.getDefault());
        } else if (BetTypes.BETTING_FOR_PLAYERS_SCORE.equals(bet.getType())) {
            result = messageSource.getMessage("bet.score", new Object[]{},
                    Locale.getDefault());
        } else if (BetTypes.BETTING_FOR_GOALS.equals(bet.getType())) {
            result = messageSource.getMessage("bet.goals", new Object[]{},
                    Locale.getDefault());
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

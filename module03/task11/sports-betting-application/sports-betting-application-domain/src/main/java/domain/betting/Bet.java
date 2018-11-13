package domain.betting;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Domain Bet class.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class Bet {

    private SportEvent sportEvent;
    private String description;
    private List<Outcome> outcomes = new ArrayList<>();
    private BetTypes type;

    private Bet() {
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public BetTypes getType() {
        return type;
    }

    public void setType(BetTypes type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bet bet = (Bet) o;
        return Objects.equals(sportEvent, bet.sportEvent)
                && Objects.equals(outcomes, bet.outcomes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportEvent, description, outcomes, type);
    }

    @Override
    public String toString() {
        return "Bet{"
                + "sportEvent=" + sportEvent
                + ", description='" + description + '\''
                + ", outcomes=" + outcomes
                + ", type=" + type
                + '}';
    }

    /**
     * inner builder.
     *
     * @return builder.
     */
    public static Builder newBuilder() {
        return new Bet().new Builder();
    }

    /**
     * inner builder.
     */
    public final class Builder {

        private Builder() {
        }

        /**
         * inner builder.
         *
         * @param sportEvent needed to be non null
         * @return builder.
         */
        public Builder setSportEvent(SportEvent sportEvent) {
            Bet.this.sportEvent = checkNotNull(sportEvent);
            return this;
        }

        /**
         * inner builder.
         *
         * @param description is not required
         * @return builder.
         */
        public Builder setDescription(String description) {
            Bet.this.description = description;
            return this;
        }

        /**
         * inner builder.
         *
         * @param outcome should be defined
         * @return builder.
         */
        public Builder setOutcome(Outcome outcome) {
            checkNotNull(outcome);
            Bet.this.outcomes.add(outcome);
            return this;
        }

        /**
         * inner builder.
         *
         * @param betType is not required
         * @return builder.
         */
        public Builder setBetType(BetTypes betType) {
            Bet.this.type = betType;
            return this;
        }

        /**
         * final builder method to obtain class.
         *
         * @return Bet.
         */
        public Bet build() {
            return Bet.this;
        }
    }
}

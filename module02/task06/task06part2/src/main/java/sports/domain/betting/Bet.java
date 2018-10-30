package sports.domain.betting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class Bet {

    private SportEvent sportEvent;
    private String description;
    private List<Outcome> outcomes = new ArrayList<>();
    private BetTypes type;

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
        return Objects.equals(sportEvent, bet.sportEvent) &&
                Objects.equals(description, bet.description) &&
                Objects.equals(outcomes, bet.outcomes) &&
                type == bet.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportEvent, description, outcomes, type);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "sportEvent=" + sportEvent +
                ", description='" + description + '\'' +
                ", outcomes=" + outcomes +
                ", type=" + type +
                '}';
    }

    private Bet() {
    }

    public static Builder newBuilder() {
        return new Bet().new Builder();
    }

    /**
     * inner builder.
     */
    public class Builder {

        private Builder() {
        }

        public Builder setSportEvent(SportEvent sportEvent) {
            Bet.this.sportEvent = sportEvent;
            return this;
        }

        public Builder setDescription(String description) {
            Bet.this.description = description;
            return this;
        }

        public Builder setOutcome(Outcome outcome) {
            Bet.this.outcomes.add(outcome);
            return this;
        }

        public Builder setBetType(BetTypes betType) {
            Bet.this.type = betType;
            return this;
        }

        public Bet build() {
            return Bet.this;
        }
    }
}

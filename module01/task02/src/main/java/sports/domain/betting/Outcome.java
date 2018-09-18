package sports.domain.betting;

import java.util.List;
import java.util.Objects;

public class Outcome {

    private String value;
    private List<OutcomeOdd> outcomeOdds;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<OutcomeOdd> getOutcomeOdd() {
        return outcomeOdds;
    }

    public void setOutcomeOdd(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcome outcome = (Outcome) o;
        return Objects.equals(value, outcome.value) &&
                Objects.equals(outcomeOdds, outcome.outcomeOdds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, outcomeOdds);
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "value='" + value + '\'' +
                ", outcomeOdd=" + outcomeOdds +
                '}';
    }


    private Outcome() {}

    public static Builder newBuilder() {
        return new Outcome().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setValue(String value) {
            Outcome.this.value = value;
            return this;
        }

        public Builder setOdd(OutcomeOdd odd) {
            Outcome.this.outcomeOdds.add(odd);
            return this;
        }

        public Outcome build() {
            return Outcome.this;
        }
    }

}

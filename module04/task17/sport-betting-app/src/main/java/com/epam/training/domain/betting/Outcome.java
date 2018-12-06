package com.epam.training.domain.betting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * outcome of sport event.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class Outcome {

    private String value;
    private List<OutcomeOdd> outcomeOdds = new ArrayList<>();

    private Outcome() {
    }

    /**
     * inner Builder.
     *
     * @return Builder
     */
    public static Builder newBuilder() {
        return new Outcome().new Builder();
    }

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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Outcome outcome = (Outcome) o;
        return Objects.equals(value, outcome.value)
                && Objects.equals(outcomeOdds, outcome.outcomeOdds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, outcomeOdds);
    }

    @Override
    public String toString() {
        return "Outcome with value " + value;
    }

    /**
     * inner Builder.
     */
    public final class Builder {

        private Builder() {
        }

        /**
         * inner Builder.
         *
         * @param value of outcome
         * @return Builder
         */
        public Builder setValue(String value) {
            Outcome.this.value = value;
            return this;
        }

        /**
         * inner Builder.
         *
         * @param odd of outcome
         * @return Builder
         */
        public Builder setOdd(OutcomeOdd odd) {
            checkNotNull(odd);
            Outcome.this.outcomeOdds.add(odd);
            return this;
        }

        /**
         * inner Builder.
         *
         * @return Outcome object.
         */
        public Outcome build() {
            return Outcome.this;
        }
    }

}

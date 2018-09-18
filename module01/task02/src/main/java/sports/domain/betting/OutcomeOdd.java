package sports.domain.betting;

import java.time.LocalDateTime;
import java.util.Objects;

public class OutcomeOdd {

    private Outcome outcome;
    private Double oddValue;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Double getOddValue() {
        return oddValue;
    }

    public void setOddValue(Double oddValue) {
        this.oddValue = oddValue;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutcomeOdd that = (OutcomeOdd) o;
        return Objects.equals(outcome, that.outcome) &&
                Objects.equals(oddValue, that.oddValue) &&
                Objects.equals(validFrom, that.validFrom) &&
                Objects.equals(validTo, that.validTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outcome, oddValue, validFrom, validTo);
    }

    @Override
    public String toString() {
        return "OutcomeOdd{" +
                "outcome=" + outcome +
                ", oddValue=" + oddValue +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}

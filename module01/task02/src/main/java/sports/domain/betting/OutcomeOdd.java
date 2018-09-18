package sports.domain.betting;

import java.time.LocalDateTime;
import java.util.Objects;

public class OutcomeOdd {

    private Double oddValue;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public OutcomeOdd(Double oddValue, LocalDateTime validFrom, LocalDateTime validTo) {
        this.oddValue = oddValue;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public OutcomeOdd(Double oddValue, LocalDateTime validFrom) {
        this.oddValue = oddValue;
        this.validFrom = validFrom;
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
        return Objects.equals(oddValue, that.oddValue) &&
                Objects.equals(validFrom, that.validFrom) &&
                Objects.equals(validTo, that.validTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oddValue, validFrom, validTo);
    }

    @Override
    public String toString() {
        return "OutcomeOdd{" +
                ", oddValue=" + oddValue +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}

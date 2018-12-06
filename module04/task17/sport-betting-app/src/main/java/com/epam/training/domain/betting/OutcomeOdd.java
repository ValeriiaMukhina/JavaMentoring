package com.epam.training.domain.betting;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * class with odds for sport event outcome.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
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
        this.oddValue = checkNotNull(oddValue);
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof OutcomeOdd)) {
            return false;
        }
        OutcomeOdd that = (OutcomeOdd) o;
        return Objects.equals(getOddValue(), that.getOddValue())
                && Objects.equals(getValidFrom(), that.getValidFrom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(oddValue, validFrom, validTo);
    }

    @Override
    public String toString() {
        return "OutcomeOdd{"
                + ", oddValue=" + oddValue
                + ", validFrom=" + validFrom
                + ", validTo=" + validTo
                + '}';
    }
}

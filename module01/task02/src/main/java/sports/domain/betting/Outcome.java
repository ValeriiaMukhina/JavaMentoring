package sports.domain.betting;

import java.util.Objects;

public class Outcome {

    private String value;
    private OutcomeOdd outcomeOdd;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcome outcome = (Outcome) o;
        return Objects.equals(value, outcome.value) &&
                Objects.equals(outcomeOdd, outcome.outcomeOdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, outcomeOdd);
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "value='" + value + '\'' +
                ", outcomeOdd=" + outcomeOdd +
                '}';
    }
}

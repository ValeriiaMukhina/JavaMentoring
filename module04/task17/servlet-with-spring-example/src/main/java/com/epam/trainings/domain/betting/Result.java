package com.epam.trainings.domain.betting;

import java.util.List;
import java.util.Objects;

/**
 * result of events.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class Result {

    private List<Outcome> realOutcomes;

    public Result(List<Outcome> realOutcomes) {
        this.realOutcomes = realOutcomes;
    }

    public List<Outcome> getRealOutcomes() {
        return realOutcomes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return Objects.equals(realOutcomes, result.realOutcomes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realOutcomes);
    }

    @Override
    public String toString() {
        return "Result{"
                + "realOutcomes=" + realOutcomes
                + '}';
    }
}

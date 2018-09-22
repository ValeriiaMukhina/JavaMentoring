package sports.domain.betting;

import java.util.List;

public class Result {

    private String description;
    private List<Outcome> realOutcomes;

    public List<Outcome> getRealOutcomes() {
        return realOutcomes;
    }

    public Result(List<Outcome> realOutcomes) {
        this.realOutcomes = realOutcomes;

    }
}

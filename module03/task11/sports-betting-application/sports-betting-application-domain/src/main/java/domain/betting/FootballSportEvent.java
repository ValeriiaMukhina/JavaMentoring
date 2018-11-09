package domain.betting;

import java.time.LocalDateTime;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class FootballSportEvent extends SportEvent {

    private FootballSportEvent() {
    }


    public static Builder newBuilder() {
        return new FootballSportEvent().new Builder();
    }

    /**
     * Builder pattern.
     */
    public class Builder {

        private Builder() {
        }

        public Builder setTitle(String title) {
            FootballSportEvent.this.setTitle(title);
            return this;
        }

        public Builder setStartDate(LocalDateTime startDate) {
            FootballSportEvent.this.setStartDate(startDate);
            return this;
        }

        public Builder setEndDate(LocalDateTime endDate) {
            FootballSportEvent.this.setStartDate(endDate);
            return this;
        }

        public FootballSportEvent build() {
            return FootballSportEvent.this;
        }
    }

    @Override
    public String toString() {
        return "FootballSportEvent{} " + super.toString();
    }
}

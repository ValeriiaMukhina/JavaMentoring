package com.epam.training.domain.betting;

import java.time.LocalDateTime;

/** Football.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public final class FootballSportEvent extends SportEvent {

    private FootballSportEvent() {
    }

    /**
     * Builder pattern.
     * @return Builder
     */
    public static Builder newBuilder() {
        return new FootballSportEvent().new Builder();
    }

    /**
     * Builder pattern.
     */
    public final class Builder {

        private Builder() {
        }
        /**
         * Builder pattern.
         * @return Builder
         * @param title of event.
         */
        public Builder setTitle(String title) {
            FootballSportEvent.this.setTitle(title);
            return this;
        }
        /**
         * Builder pattern.
         * @return Builder
         * @param startDate of event.
         */
        public Builder setStartDate(LocalDateTime startDate) {
            FootballSportEvent.this.setStartDate(startDate);
            return this;
        }
        /**
         * Builder pattern.
         * @return Builder
         * @param endDate of event.
         */
        public Builder setEndDate(LocalDateTime endDate) {
            FootballSportEvent.this.setStartDate(endDate);
            return this;
        }
        /**
         * Builder pattern.
         * @return football event object.
         */
        public FootballSportEvent build() {
            return FootballSportEvent.this;
        }
    }

    @Override
    public String toString() {
        return "FootballSportEvent{} " + super.toString();
    }
}

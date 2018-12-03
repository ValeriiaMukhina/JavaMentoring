package com.epam.trainings.domain.betting;

import java.time.LocalDateTime;

/** Tennis domain class.
 * @author  Valeriia Biruk
 * @version 1.0
 */
public final class TennisSportEvent extends SportEvent {

    private TennisSportEvent() {
    }
    /**
     *Builder pattern.
     * @return builder object
     */
    public static Builder newBuilder() {
        return new TennisSportEvent().new Builder();
    }

    /**
     *Builder pattern.
     */
    public final class Builder {

        private Builder() {
        }
        /**
         *Builder pattern.
         * @return builder object
         * @param title of event
         */
        public Builder setTitle(String title) {
            TennisSportEvent.this.setTitle(title);
            return this;
        }
        /**
         *Builder pattern.
         * @return builder object
         * @param startDate start date of event
         */
        public Builder setStartDate(LocalDateTime startDate) {
            TennisSportEvent.this.setStartDate(startDate);
            return this;
        }
        /**
         *Builder pattern.
         * @return builder object
         * @param endDate end data of event
         */
        public Builder setEndDate(LocalDateTime endDate) {
            TennisSportEvent.this.setStartDate(endDate);
            return this;
        }
        /**
         *Builder pattern.
         * @return Tennis event object
         *
         */
        public TennisSportEvent build() {
            return TennisSportEvent.this;
        }

    }

    @Override
    public String toString() {
        return "TennisSportEvent{} " + super.toString();
    }
}

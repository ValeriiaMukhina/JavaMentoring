package sports.domain.betting;

import java.time.LocalDateTime;

public class TennisSportEvent extends SportEvent {

    private TennisSportEvent() {
    }

    public static Builder newBuilder() {
        return new TennisSportEvent().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setTitle(String title) {
            TennisSportEvent.this.setTitle(title);
            return this;
        }

        public Builder setStartDate(LocalDateTime startDate) {
            TennisSportEvent.this.setStartDate(startDate);
            return this;
        }

        public Builder setEndDate(LocalDateTime endDate) {
            TennisSportEvent.this.setStartDate(endDate);
            return this;
        }

        public TennisSportEvent build() {
            return TennisSportEvent.this;
        }

    }

    @Override
    public String toString() {
        return "TennisSportEvent{} " + super.toString();
    }
}

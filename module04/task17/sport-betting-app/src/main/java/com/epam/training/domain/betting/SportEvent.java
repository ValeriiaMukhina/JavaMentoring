package com.epam.training.domain.betting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Main class for sport event.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public abstract class SportEvent {

    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets = new ArrayList<>();
    private Result eventResult;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getEventResult() {
        return eventResult;
    }

    public void setEventResult(Result eventResult) {
        this.eventResult = eventResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SportEvent)) {
            return false;
        }
        SportEvent that = (SportEvent) o;
        return Objects.equals(getTitle(), that.getTitle())
                && Objects.equals(getStartDate(), that.getStartDate())
                && Objects.equals(getEndDate(), that.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startDate, endDate, bets, eventResult);
    }

    @Override
    public String toString() {
        return "SportEvent{"
                + "title='" + title + '\''
                + ", startDate=" + startDate
                + ", endDate=" + endDate
                + ", bets=" + bets
                + ", eventResult=" + eventResult
                + '}';
    }
}

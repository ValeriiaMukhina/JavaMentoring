package sports.service;

import sports.domain.betting.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Service {

    public List<PossibleBetDescription>  listAllBets(List<SportEvent> sportEvents) {
        List<PossibleBetDescription> possibleBets = new LinkedList<>();
        sportEvents.forEach(

                        event -> event.getBets().forEach(
                                bet -> bet.getOutcomes().forEach(
                                        outcome -> outcome.getOutcomeOdd().stream()
                                                .filter(
                                                outcomeOdd -> outcomeOdd.getValidFrom().isBefore(LocalDateTime.now()) &&
                                                        (outcomeOdd.getValidTo() == null ||
                                                         outcomeOdd.getValidTo().isAfter(LocalDateTime.now()))
                                        ).forEach(
                                                outcomeOdd -> possibleBets.add(
                                                        new PossibleBetDescription(
                                                                event,
                                                                bet,
                                                                outcome,
                                                                outcomeOdd
                                                        )
                                                )
                                )
                                )
                        )
        );
        return possibleBets;
    }




    public class PossibleBetDescription {
        private String description;

        private PossibleBetDescription(SportEvent sportEvent, Bet bet, Outcome outcome, OutcomeOdd outcomeOdd) {
            StringBuilder descriptionBuilder = new StringBuilder( "Bet on ")
                    .append(sportEvent.getTitle())
                    .append(", ")
                    .append(bet.getDescription());
                    if(BetTypes.BETTING_FOR_WINNER.equals(bet.getType())) {
                        descriptionBuilder.append("The winner will be ");
                    }
                    else if(BetTypes.BETTING_FOR_PLAYERS_SCORE.equals(bet.getType()))
                    {

                    }
                    else if(BetTypes.BETTING_FOR_GOALS.equals(bet.getType())){

            }
                        descriptionBuilder.append(outcome.getValue())
                    .append( ". The odd on this is ")
                    .append(outcomeOdd.getOddValue())
                    .append(", valid from ")
                    .append(outcomeOdd.getValidFrom().format(DateTimeFormatter.ISO_DATE_TIME));
                    if (outcomeOdd.getValidTo() != null) {
                        descriptionBuilder.append(" to ")
                                .append(outcomeOdd.getValidTo().format(DateTimeFormatter.ISO_DATE_TIME));
                    }
                    description = descriptionBuilder.toString();
        }

        @Override
        public String toString() {
            return description;
        }
    }



}

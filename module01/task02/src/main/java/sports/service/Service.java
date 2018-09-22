package sports.service;

import sports.domain.betting.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {

    public List<PossibleBetDescription> listAllBets(List<SportEvent> sportEvents) {
        AtomicInteger numberOfBet = new AtomicInteger(1);
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
                                                                numberOfBet.getAndIncrement(),
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


    public void generateResults(List<SportEvent> sportEvents) {
        Random rand = new Random();
        sportEvents.forEach(
                sportEvent -> {
                    List<Outcome> realOutcomes = new ArrayList<>();

                    sportEvent.getBets().forEach(
                            bet -> {
                                int winOutcome = rand.nextInt(bet.getOutcomes().size());
                                realOutcomes.add(bet.getOutcomes().get(winOutcome));
                            }

                    );
                    sportEvent.setEventResult(new Result(realOutcomes));
                }
        );
    }


    public PossibleBetDescription getPossibleBetDescriptionByIndex(List<PossibleBetDescription> bets, int index) {
        return bets.get(index - 1);
    }


    public double calculatePrize(List<SportEvent> sportEvents, List<Wager> wagers) {
        final double[] prize = {0};
        sportEvents.stream().filter(sportEvent -> sportEvent.getEventResult() != null).forEach(
                sportEvent -> {
                    sportEvent.getEventResult().getRealOutcomes().forEach(
                            outcome -> {
                                System.out.println(outcome + " has won");
                                wagers.forEach(
                                        wager -> {
                                            if (wager.processWin(outcome.getOutcomeOdd())) {
                                                System.out.println("You have won " + wager.getAmount() + " " + wager.getPlayer().getCurrency());
                                                prize[0] = wager.getAmount();
                                            }
                                        }
                                );
                            });
                }

        );
        return prize[0];
    }
}

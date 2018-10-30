package sports.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import sports.domain.betting.*;

/**
 * Service class.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class BetCalculationService {

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

    public List<Outcome> getRealOutcomes(List<SportEvent> sportEvents) {
        List<Outcome> realOutcomes = new ArrayList<>();
        sportEvents.stream().filter(sportEvent -> sportEvent.getEventResult() != null).forEach(
                sportEvent -> realOutcomes.addAll(sportEvent.getEventResult().getRealOutcomes()));
        return realOutcomes;
    }

    public List<Double> calculatedPrizes(List<Outcome> realOutcomes, List<Wager> wagers) {
        List<Double> prizes = new ArrayList<>();
        realOutcomes.forEach(
                outcome -> wagers.forEach(
                        wager -> {
                            if (wager.processWin(outcome.getOutcomeOdd())) {
                                prizes.add(wager.getAmount());
                            }
                        }
                )
        );
        return prizes;
    }
}

package service;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import domain.betting.Outcome;
import domain.betting.Result;
import domain.betting.SportEvent;
import domain.betting.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
@Service
public class BetCalculationService {

    @Autowired private PossibleBetDescription possibleBetDescription;
    /**
     * describe all bets.
     * @param  sportEvents all possible evens
     * @return all descriptions of possible bets
     */
    public List<PossibleBetDescription> listAllBets(List<SportEvent> sportEvents) {
        checkNotNull(sportEvents);
        AtomicInteger numberOfBet = new AtomicInteger(1);
        List<PossibleBetDescription> possibleBets = new LinkedList<>();
        sportEvents.forEach(event -> event.getBets().forEach(bet -> bet.getOutcomes().forEach(outcome -> outcome.getOutcomeOdd().stream()
                                        .filter(
                                            outcomeOdd -> outcomeOdd.getValidFrom().isBefore(LocalDateTime.now())
                                                        && (outcomeOdd.getValidTo() == null
                                                        || outcomeOdd.getValidTo().isAfter(LocalDateTime.now()))
                                        ).forEach(
                                                outcomeOdd -> possibleBets.add(
                                                        possibleBetDescription.init(numberOfBet.getAndIncrement(), event, bet, outcome, outcomeOdd)
                                                )
                                        )
                        )
                )
        );
        return possibleBets;
    }
    /**
     * generates results of sport events.
     * @param  sportEvents all events
     */
    public void generateResults(List<SportEvent> sportEvents) {
        checkNotNull(sportEvents);
        Random rand = new Random();
        sportEvents.forEach(sportEvent -> {
                List<Outcome> realOutcomes = new ArrayList<>();
                sportEvent.getBets().forEach(bet -> {
                    int winOutcome = rand.nextInt(bet.getOutcomes().size());
                    realOutcomes.add(bet.getOutcomes().get(winOutcome));
                    }

                );
                sportEvent.setEventResult(new Result(realOutcomes));

        }
        );
    }
    /**
     * generates outcomes.
     * @param  bets all bets
     * @param index of bet to found
     * @return description of bet by index
     */
    public PossibleBetDescription getPossibleBetDescriptionByIndex(List<PossibleBetDescription> bets, int index) {
        checkPositionIndex(index, bets.size());
        return bets.get(index - 1);
    }
    /**
     * generates outcomes.
     * @param  sportEvents all possible evens
     * @return all outcomes
     */
    public List<Outcome> getRealOutcomes(List<SportEvent> sportEvents) {
        checkNotNull(sportEvents);
        List<Outcome> realOutcomes = new ArrayList<>();
        sportEvents.stream().filter(sportEvent -> sportEvent.getEventResult() != null).forEach(
            sportEvent -> realOutcomes.addAll(sportEvent.getEventResult().getRealOutcomes()));
        return realOutcomes;
    }
    /**
     * generates outcomes.
     * @param  realOutcomes all outcomes
     * @param wagers wage
     * @return all won prizes
     */
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

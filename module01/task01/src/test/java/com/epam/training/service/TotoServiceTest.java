package com.epam.training.service;

import com.epam.training.domain.Hit;
import com.epam.training.domain.Outcomes;
import com.epam.training.domain.Round;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.epam.training.utils.InputParser.parseCurrencyToBigDecimal;
import static com.epam.training.utils.InputParser.parseLocalDate;
import static org.junit.Assert.assertEquals;


public class TotoServiceTest {

    private List<Round> rounds;

    @Before
    public void setUpTestData() {
        //015;44;1;2015.10.29.;23;76 500 UAH;46;9 640 UAH;1410;355 UAH;7800;185 UAH;18990;0 UAH;2;1;1;1;2;2;2;1;2;1;1;1;1;+2

        Round round1 = new Round();
        round1.setYear("2015");
        round1.setWeek("44");
        round1.setRound(1);
        round1.setDate(parseLocalDate("2015.10.29."));
        Hit hit14 = new Hit(14, 23, parseCurrencyToBigDecimal("76 500 UAH"));
        Hit hit13 = new Hit(13, 46, parseCurrencyToBigDecimal("9 640 UAH"));
        Hit hit12 = new Hit(12, 1410, parseCurrencyToBigDecimal("355 UAH"));
        Hit hit11 = new Hit(11, 7800, parseCurrencyToBigDecimal("185 UAH"));
        Hit hit10 = new Hit(10, 18990, parseCurrencyToBigDecimal("0 UAH"));
        round1.setHits(new Hit[]{hit14, hit13, hit12, hit11, hit10});
        Outcomes[] outcomes1 = new Outcomes[]{
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN};
        round1.setOutcomes(outcomes1);
//2015;43;2;2015.10.26.;99;164 630 UAH;23;16 415 UAH;1738;865 UAH;10187;145 UAH;32184;90 UAH;1;1;2;2;1;1;X;1;1;2;1;2;X;+1
        Round round2 = new Round();
        round2.setYear("2015");
        round2.setWeek("43");
        round2.setRound(2);
        round2.setDate(parseLocalDate("2015.10.26."));
        Hit hit142 = new Hit(14, 99, parseCurrencyToBigDecimal("164 630 UAH"));
        Hit hit132 = new Hit(13, 23, parseCurrencyToBigDecimal("16 415 UAH"));
        Hit hit122 = new Hit(12, 1738, parseCurrencyToBigDecimal("865 UAH"));
        Hit hit112 = new Hit(11, 10187, parseCurrencyToBigDecimal("145 UAH"));
        Hit hit102 = new Hit(10, 32184, parseCurrencyToBigDecimal("90 UAH"));
        round2.setHits(new Hit[]{hit142, hit132, hit122, hit112, hit102});
        Outcomes[] outcomes2 = new Outcomes[]{
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.DRAW,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.DRAW,
                Outcomes.FIRST_TEAM_WIN};
        round2.setOutcomes(outcomes2);
        rounds = new ArrayList<>();
        rounds.add(round1);
        rounds.add(round2);
    }

    @Test
    public void testGetLargestPrizeEverRecorded() {
        assertEquals(new BigDecimal("164630"), new TotoService().getLargestPrizeForAllGames(rounds));
    }

    @Test
    public void testGetHitsNumber() {
        Outcomes[] supposedOutcomes = new Outcomes[]{
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.DRAW,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.FIRST_TEAM_WIN,
                Outcomes.SECOND_TEAM_WIN,
                Outcomes.DRAW,
                Outcomes.DRAW};

        assertEquals(13, new TotoService().getHitsNumber(rounds.get(1), supposedOutcomes));
    }

    @Test
    public void testGetPrizeForHitsNumber() {
        assertEquals(new BigDecimal(16415), new TotoService().getPrizeForHitsNumber(rounds.get(1), 13));
    }

    @Test
    public void testGetRoundOnDate() {
        assertEquals(rounds.get(1), new TotoService().getRoundOnDate(rounds, LocalDate.of(2015, 10, 26)));
    }

    @Test
    public void tesGetDistribution() {
        assertEquals(0.57, new TotoService().getDistribution(rounds.get(0)).getFirstTeamWinsPercentage(), 0.1);
        assertEquals(0.43, new TotoService().getDistribution(rounds.get(0)).getSecondTeamWinsPercentage(), 0.1);
        assertEquals(0, new TotoService().getDistribution(rounds.get(0)).getDrawPercentage(), 0.1);
    }
}
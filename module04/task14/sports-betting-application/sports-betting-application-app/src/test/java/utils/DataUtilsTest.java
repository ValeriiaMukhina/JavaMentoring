package utils;

import domain.betting.Currency;
import org.junit.Assert;
import org.junit.Test;
import utils.DataUtils;

import java.time.LocalDate;

public class DataUtilsTest {

    @Test
    public void getEURTest() {
        Assert.assertEquals(Currency.EUR, DataUtils.getCurrency("EUR"));
    }

    @Test
    public void getUSDTest() {
        Assert.assertEquals(Currency.USD, DataUtils.getCurrency("USD"));
    }

    @Test
    public void getHUFTest() {
        Assert.assertEquals(Currency.HUF, DataUtils.getCurrency("HUF"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCurrencyNegativeCase() {
        DataUtils.getCurrency("FFF");
    }

    @Test
    public void getValidDateTest() {
        Assert.assertEquals(LocalDate.of(1990,12,11), DataUtils.getDate("1990-12-11"));
    }

    @Test
    public void getExitOptionTest() {
        Assert.assertEquals(0, DataUtils.getOption("q"));
    }

    @Test
    public void getValidOptionTest() {
        Assert.assertEquals(1, DataUtils.getOption("1"));
    }
}

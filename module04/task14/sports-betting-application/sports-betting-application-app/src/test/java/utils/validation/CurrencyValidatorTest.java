package utils.validation;

import domain.betting.Currency;
import org.junit.Assert;
import org.junit.Test;

public class CurrencyValidatorTest {

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(new CurrencyValidator().isValid("not a Currency"));
    }

    @Test
    public void isValidPositiveCaseEur() {
        Assert.assertTrue(new CurrencyValidator().isValid(Currency.EUR.name()));
    }

    @Test
    public void isValidPositiveCaseUsd() {
        Assert.assertTrue(new CurrencyValidator().isValid(Currency.USD.name()));
    }

    @Test
    public void isValidPositiveCaseHuf() {
        Assert.assertTrue(new CurrencyValidator().isValid(Currency.HUF.name()));
    }
}
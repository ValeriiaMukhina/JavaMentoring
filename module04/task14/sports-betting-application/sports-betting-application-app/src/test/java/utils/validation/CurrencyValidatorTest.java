package utils.validation;

import domain.betting.Currency;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runner.AppConfig;

import java.util.Locale;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class CurrencyValidatorTest {

    @Autowired CurrencyValidator currencyValidator;

    @BeforeClass
    public static void setLocale() {
        Locale.setDefault(Locale.US);
    }

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(currencyValidator.isValid("not a Currency"));
    }

    @Test
    public void isValidPositiveCaseEur() {
        Assert.assertTrue(currencyValidator.isValid(Currency.EUR.name()));
    }

    @Test
    public void isValidPositiveCaseUsd() {
        Assert.assertTrue(currencyValidator.isValid(Currency.USD.name()));
    }

    @Test
    public void isValidPositiveCaseHuf() {
        Assert.assertTrue(currencyValidator.isValid(Currency.HUF.name()));
    }
}
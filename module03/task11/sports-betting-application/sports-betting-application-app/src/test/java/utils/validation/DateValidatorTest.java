package utils.validation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateValidatorTest {

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(new DateValidator().isValid("1991-13-12"));
    }

    @Test
    public void isValidPositiveCase() {
        Assert.assertTrue(new DateValidator().isValid("1991-12-12"));
    }
}
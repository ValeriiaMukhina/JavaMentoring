package utils.validation;

import org.junit.Assert;
import org.junit.Test;

public class DoubleValidatorTest {

    @Test
    public void isValidPositiveCase() {
        Assert.assertTrue(new DoubleValidator().isValid("3.9"));
    }

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(new DoubleValidator().isValid("3,9"));
    }
}
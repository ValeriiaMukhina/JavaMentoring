package utils.validation;

import org.junit.Assert;
import org.junit.Test;

public class OptionValidatorTest {

    @Test
    public void isValidBoundaryValue() {
        Assert.assertTrue(new OptionValidator(8).isValid("8"));
    }

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(new OptionValidator(8).isValid("9"));
    }

    @Test
    public void isValidPositiveCase() {
        Assert.assertTrue(new OptionValidator(8).isValid("7"));
    }

    @Test
    public void isValidWithQuit() {
        Assert.assertTrue(new OptionValidator(8).isValid("q"));
    }
}

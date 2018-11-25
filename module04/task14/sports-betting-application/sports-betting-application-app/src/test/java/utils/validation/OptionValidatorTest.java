package utils.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class OptionValidatorTest {
    @Autowired
    OptionValidator optionValidator;

    @Before
    public void setMaxSize() {
        optionValidator.setOptionMaxValue(8);
    }

    @Test
    public void isValidBoundaryValue() {
        Assert.assertTrue(
                optionValidator.isValid("8"));
    }

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(optionValidator.isValid("9"));
    }

    @Test
    public void isValidPositiveCase() {
        Assert.assertTrue(optionValidator.isValid("7"));
    }

    @Test
    public void isValidWithQuit() {
        Assert.assertTrue(optionValidator.isValid("q"));
    }
}

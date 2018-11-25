package utils.validation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class DoubleValidatorTest {
    @Autowired
    DoubleValidator doubleValidator;


    @Test
    public void isValidPositiveCase() {
        Assert.assertTrue(doubleValidator.isValid("3.9"));
    }

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(doubleValidator.isValid("3,9"));
    }
}
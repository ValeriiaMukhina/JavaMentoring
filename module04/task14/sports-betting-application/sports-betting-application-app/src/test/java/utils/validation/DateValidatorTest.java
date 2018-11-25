package utils.validation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class DateValidatorTest {

    @Autowired
    DateValidator dateValidator;

    @Test
    public void isValidNegativeCase() {
        Assert.assertFalse(dateValidator.isValid("1991-13-12"));
    }

    @Test
    public void isValidPositiveCase() {
        Assert.assertTrue(dateValidator.isValid("1991-12-12"));
    }
}
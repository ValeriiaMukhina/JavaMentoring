package runner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class AppTest
{

    @Autowired
    private GameDataGenerator gameDataGenerator;

    @BeforeClass
    public static void setLocale() {
        Locale.setDefault(Locale.US);
    }

    @Test
    public void testGameDataGenerator()
    {
       Assert.assertTrue(gameDataGenerator.createTestData().size() > 0);
    }
}

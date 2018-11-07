package sports;

import org.junit.Assert;
import org.junit.Test;
import runner.GameDataGenerator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testGameDataGenerator()
    {
        Assert.assertTrue(GameDataGenerator.createTestData().size() > 0);
    }
}

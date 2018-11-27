package game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runner.Game;
import utils.ConsoleReader;
import utils.validation.DoubleValidator;
import utils.validation.OptionValidator;

import java.util.Locale;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@PrepareForTest(ConsoleReader.class)
@ContextConfiguration(classes = {TestConfig.class})
public class GameTestExit {

    @Autowired
    @InjectMocks
    private Game game;
    @Autowired
    private OptionValidator optionValidator;
    @Autowired
    private DoubleValidator doubleValidator;

    @BeforeClass
    public static void setLocale() {
        Locale.setDefault(Locale.US);
    }

    @Before
    public void generateTestData() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyExitFromGame() {
        PowerMockito.mockStatic(ConsoleReader.class);
        when(ConsoleReader.read(optionValidator)).thenReturn("0", "0");
        //When
        game.start();
        //Then
        Assert.assertTrue(game.getWagers().isEmpty());
    }
}
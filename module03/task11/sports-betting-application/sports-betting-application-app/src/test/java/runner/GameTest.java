package runner;

import domain.betting.SportEvent;
import domain.user.Player;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

public class GameTest {

    @Mock  Player player;
    @Mock List<SportEvent> sportEvents;



    @Test
    public void start() {
        Game game = new Game(player,sportEvents);
        //when(game.).thenReturn(43);
        game.start();


    }
}
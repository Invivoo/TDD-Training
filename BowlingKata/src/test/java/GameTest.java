import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void should_return_score_0_when_20_rolls_of_0_pin() {
        //Given

        //When
        int nbRolls = 20;
        int pins = 0;
        for (int i = 0; i < nbRolls; i++) {
            game.roll(pins);
        }

        //Then
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void should_return_score_20_when_20_rolls_of_1_pin() {
        //Given

        //When
        int nbRolls = 20;
        int pins = 1;
        for (int i = 0; i < nbRolls; i++) {
            game.roll(pins);
        }

        //Then
        assertThat(game.score()).isEqualTo(20);
    }
}

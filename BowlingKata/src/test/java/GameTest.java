import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    private void rollMany(int nbRolls, int pins) {
        for (int i = 0; i < nbRolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void should_return_score_0_when_20_rolls_of_0_pin() {
        //Given

        //When
        rollMany(20, 0);

        //Then
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void should_return_score_20_when_20_rolls_of_1_pin() {
        //Given

        //When
        rollMany(20, 1);

        //Then
        assertThat(game.score()).isEqualTo(20);
    }
}

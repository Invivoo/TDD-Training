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

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
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

    @Test
    public void should_return_score_16_when_spare_and_roll_of_3_pins() {
        //Given

        //When
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        //Then
        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    public void should_return_score_24_when_strike_and_rolls_of_3_and_4_pins() {
        //Given

        //When
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);

        //Then
        assertThat(game.score()).isEqualTo(24);
    }

}

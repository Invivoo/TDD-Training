import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    public void should_return_score_0_when_20_rolls_of_0_pin() {
        //Given
        Game game = new Game();

        //When
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        //Then
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void should_return_score_20_when_20_rolls_of_1_pin() {
        //Given
        Game game = new Game();

        //When
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }

        //Then
        assertThat(game.score()).isEqualTo(20);
    }
}

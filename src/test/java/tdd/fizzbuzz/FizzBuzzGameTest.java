package tdd.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzGameTest {

    private FizzBuzzGame fizzBuzzGame;

    @BeforeEach
    void setUp() {
        fizzBuzzGame = new FizzBuzzGame();
    }

    @Test
    void game_for_one_should_contain_only_one() {
        String gameResult = fizzBuzzGame.play(1);

        assertThat(gameResult).isEqualTo("1");
    }

    @Test
    void game_for_three() {
        String gameResult = fizzBuzzGame.play(3);

        assertThat(gameResult).isEqualTo("1,2,Fizz");
    }

    @Test
    void game_for_fifteen() {
        String gameResult = fizzBuzzGame.play(15);

        assertThat(gameResult).isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz");
    }

    @Test
    void game_for_zero_is_not_allowed() {
        assertThrows(DurationNotAllowedException.class, () -> fizzBuzzGame.play(0));
    }

    @Test
    void game_for_more_then_hundred_is_not_allowed() {
        assertThrows(DurationNotAllowedException.class, () -> fizzBuzzGame.play(101));
    }
}
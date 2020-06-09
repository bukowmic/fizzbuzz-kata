package tdd.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzGameTest {

    @Test
    void game_for_one_should_contain_only_one() {
        String gameResult = FizzBuzzGame.standardGame().play(1);

        assertThat(gameResult).isEqualTo("1");
    }

    @Test
    void game_for_fifteen_should_represent() {
        String gameResult = FizzBuzzGame.standardGame().play(15);

        assertThat(gameResult).isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz");
    }

    @Test
    void game_with_another_strategy_to_say_Bar() {
        FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzCommonStrategies.standardFizzStrategy(),
                FizzBuzzCommonStrategies.standardBuzzStrategy(),
                FizzBuzzCommonStrategies.commonDividingStrategy(7, "Bar"));

        String gameResult = new FizzBuzzGame(fizzBuzz).play(21);

        assertThat(gameResult).isEqualTo("1,2,Fizz,4,Buzz,Fizz,Bar,8,Fizz,Buzz,11,Fizz,13,Bar,FizzBuzz,16,17,Fizz,19,Buzz,FizzBar");
    }

    @Test
    void game_with_5_7_9_dividers() {
        FizzBuzz fizzBuzz = new FizzBuzz(FizzBuzzCommonStrategies.commonDividingStrategy(5, "Fizz"),
                FizzBuzzCommonStrategies.commonDividingStrategy(7, "Buzz"),
                FizzBuzzCommonStrategies.commonDividingStrategy(9, "Bar"));

        String gameResult = new FizzBuzzGame(fizzBuzz).play(21);

        assertThat(gameResult).isEqualTo("1,2,3,4,Fizz,6,Buzz,8,Bar,Fizz,11,12,13,Buzz,Fizz,16,17,Bar,19,Fizz,Buzz");
    }

    @Test
    void game_for_zero_is_not_allowed() {
        assertThrows(DurationNotAllowedException.class, () -> FizzBuzzGame.standardGame().play(0));
    }

    @Test
    void game_for_more_then_hundred_is_not_allowed() {
        assertThrows(DurationNotAllowedException.class, () -> FizzBuzzGame.standardGame().play(101));
    }
}
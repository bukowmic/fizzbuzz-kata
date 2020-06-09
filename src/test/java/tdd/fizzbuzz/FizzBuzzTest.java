package tdd.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {

    @Test
    public void number_representation_of_one_is_one() {
        String representation = FizzBuzzCommonStrategies.standardRepresentation().numberRepresentation(1);

        assertThat(representation).isEqualTo("1");
    }

    @Test
    void number_representation_of_three_is_Fizz() {
        String representation = FizzBuzzCommonStrategies.standardRepresentation().numberRepresentation(3);

        assertThat(representation).isEqualTo("Fizz");
    }

    @Test
    void number_representation_of_five_is_Buzz() {
        String representation = FizzBuzzCommonStrategies.standardRepresentation().numberRepresentation(5);

        assertThat(representation).isEqualTo("Buzz");
    }

    @Test
    void number_representation_of_fifteen_is_FizzBuzz() {
        String representation = FizzBuzzCommonStrategies.standardRepresentation().numberRepresentation(15);

        assertThat(representation).isEqualTo("FizzBuzz");
    }

    @Test
    void number_representation_of_wrong_number_throws_exception() {
        assertThrows(NumberNotAllowedException.class, () -> FizzBuzzCommonStrategies.standardRepresentation().numberRepresentation(-1));
    }

    @Test
    void change_representation_strategy_to_represent_numbers_with_3_as_Fizz() {
        Function<Integer, String> numberWithThreeStrategy = numberWithThreeStrategyForFizz();
        FizzBuzz fizzBuzz = new FizzBuzz(numberWithThreeStrategy);
        String representation = fizzBuzz.numberRepresentation(31);

        assertThat(representation).isEqualTo("Fizz");
    }

    @Test
    void change_representation_strategy_to_represent_numbers_with_3_and_divided_by_5_as_FizzBuzz() {
        Function<Integer, String> numberWithThreeStrategy = numberWithThreeStrategyForFizz();
        FizzBuzz fizzBuzz = new FizzBuzz(numberWithThreeStrategy, FizzBuzzCommonStrategies.standardBuzzStrategy());
        String representation = fizzBuzz.numberRepresentation(35);

        assertThat(representation).isEqualTo("FizzBuzz");
    }

    private Function<Integer, String> numberWithThreeStrategyForFizz() {
        return number -> number % 3 == 0 || String.valueOf(number).contains("3") ? "Fizz" : "";
    }
}

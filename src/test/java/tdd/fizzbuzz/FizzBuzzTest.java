package tdd.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void number_representation_of_one_is_one() {
        String representation = fizzBuzz.numberRepresentation(1);

        assertThat(representation).isEqualTo("1");
    }

    @Test
    void number_representation_of_three_is_Fizz() {
        String representation = fizzBuzz.numberRepresentation(3);

        assertThat(representation).isEqualTo("Fizz");
    }

    @Test
    void number_representation_of_five_is_Buzz() {
        String representation = fizzBuzz.numberRepresentation(5);

        assertThat(representation).isEqualTo("Buzz");
    }

    @Test
    void number_representation_of_fifteen_is_FizzBuzz() {
        String representation = fizzBuzz.numberRepresentation(15);

        assertThat(representation).isEqualTo("FizzBuzz");
    }
}

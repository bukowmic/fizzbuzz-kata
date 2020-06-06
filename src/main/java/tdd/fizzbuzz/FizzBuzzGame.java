package tdd.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzGame {
    public String play(int gameDuration) {
        if (gameDuration <= 0 || gameDuration > 100) {
            throw new DurationNotAllowedException();
        }
        FizzBuzz fizzBuzz = new FizzBuzz();
        return IntStream.rangeClosed(1, gameDuration)
                .mapToObj(fizzBuzz::numberRepresentation)
                .collect(Collectors.joining(","));
    }
}

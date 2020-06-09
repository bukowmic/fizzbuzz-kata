package tdd.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzGame {
    private final FizzBuzz fizzBuzz;

    public FizzBuzzGame(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public static FizzBuzzGame standardGame() {
        return new FizzBuzzGame(FizzBuzzCommonStrategies.standardRepresentation());
    }

    public String play(int gameDuration) {
        if (gameDuration <= 0 || gameDuration > 100) {
            throw new DurationNotAllowedException();
        }

        return IntStream.rangeClosed(1, gameDuration)
                .mapToObj(fizzBuzz::numberRepresentation)
                .collect(Collectors.joining(","));
    }
}

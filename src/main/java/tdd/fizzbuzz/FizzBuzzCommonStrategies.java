package tdd.fizzbuzz;

import java.util.function.Function;

public class FizzBuzzCommonStrategies {
    private FizzBuzzCommonStrategies() {
    }

    public static FizzBuzz standardRepresentation() {
        return new FizzBuzz(standardFizzStrategy(), standardBuzzStrategy());
    }

    public static Function<Integer, String> standardFizzStrategy() {
        return number -> number % 3 == 0 ? "Fizz" : "";
    }

    public static Function<Integer, String> standardBuzzStrategy() {
        return number -> number % 5 == 0 ? "Buzz" : "";
    }

    public static Function<Integer, String> commonDividingStrategy(int divider, String whatToSay) {
        return number -> number % divider == 0 ? whatToSay : "";
    }
}

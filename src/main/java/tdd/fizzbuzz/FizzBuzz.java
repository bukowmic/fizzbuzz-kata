package tdd.fizzbuzz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FizzBuzz {
    private final List<Function<Integer, String>> representationStrategies;

    @SafeVarargs
    public FizzBuzz(Function<Integer, String>... representationStrategies) {
        this.representationStrategies = new LinkedList<>();
        this.representationStrategies.addAll(Arrays.asList(representationStrategies));
    }

    public String numberRepresentation(int number) {
        if (number <= 0) {
            throw new NumberNotAllowedException();
        }

        return representationStrategies.stream()
                .map(strategy -> strategy.apply(number))
                .filter(somethingSaid -> !somethingSaid.isEmpty())
                .collect(Collectors.collectingAndThen(Collectors.joining(),
                        finalSaid -> finalSaid.isEmpty() ? String.valueOf(number) : finalSaid));
    }
}

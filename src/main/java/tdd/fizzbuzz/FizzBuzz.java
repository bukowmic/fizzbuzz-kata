package tdd.fizzbuzz;

public class FizzBuzz {

    public String numberRepresentation(int number) {
        String representation = "";
        if (number % 3 == 0) {
            representation += "Fizz";
        }
        if (number % 5 == 0) {
            representation += "Buzz";
        }
        return representation.isEmpty() ? String.valueOf(number) : representation;
    }
}

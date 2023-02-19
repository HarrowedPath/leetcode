import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> expectedOutput = Arrays.asList("1", "2", "Fizz");
        assert expectedOutput.equals(new FizzBuzz().fizzBuzz(3));
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}

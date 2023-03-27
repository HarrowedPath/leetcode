package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        boolean expectedOutput = true;
        assert expectedOutput == new HappyNumber().isHappy(19);
    }

    public boolean isHappy(int n) {
        Set<Integer> sumsOfSquares = new HashSet<>();
        sumsOfSquares.add(n);

        int sumOfSquare;
        int lastElementOfSet = n;
        while (true) {
            if (sumsOfSquares.contains(1)) {
                return true;
            }
            sumOfSquare = 0;
            while (lastElementOfSet > 0) {
                sumOfSquare += (int) Math.pow(lastElementOfSet % 10, 2);
                lastElementOfSet /= 10;
            }
            sumOfSquare += (int) Math.pow(lastElementOfSet % 10, 2);
            if (sumsOfSquares.contains(sumOfSquare)) {
                return false;
            } else {
                sumsOfSquares.add(sumOfSquare);
            }
            lastElementOfSet = sumOfSquare;
        }
    }
}

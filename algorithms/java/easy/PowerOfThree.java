package easy;

public class PowerOfThree {
    public static void main(String[] args) {
        boolean expectedOutput = true;
        assert expectedOutput == new PowerOfThree().iterative(27);
        assert expectedOutput == new PowerOfThree().recursiveOne(27);
        assert expectedOutput == new PowerOfThree().oneLineMemes(27);
        assert expectedOutput == new PowerOfThree().mathLog(27);
    }

    public boolean recursiveOne(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && recursiveOne(n / 3)));
    }

    public boolean oneLineMemes(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    public boolean iterative(int n) {
        if (n == 1) {
            return true;
        }
        long power = 1;
        while (power < n) {
            power *= 3;
            if (power == n) {
                return true;
            }
        }
        return false;
    }

    public boolean mathLog(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

package easy;

public class FibonacciNumber {
    public static void main(String[] args) {
        int output = new FibonacciNumber().fib(4);
        assert 3 == output;
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int cur = 1;
        int prev = 1;
        for (int i = 2; i < n; i++) {
            int temp = cur + prev;
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}

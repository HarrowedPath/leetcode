package easy;

public class ClimbingStairs {

    public static void main(String[] args) {
        int output = new ClimbingStairs().climbStairs(5);
        assert 8 == output;
    }

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int cur = 2;
        int prev = 1;
        for (int i = 2; i < n; i++) {
            int temp = cur + prev;
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}

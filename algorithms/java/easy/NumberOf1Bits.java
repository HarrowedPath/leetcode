package easy;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int expectedOutput = 31;
        assert expectedOutput == new NumberOf1Bits().hammingWeight(-3);
    }

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            // check last index of binary n
            ones += (n & 1);
            // shift by one on the right for the next bit (unsigned operator)
            n >>>= 1;
        }
        return ones;
    }
}

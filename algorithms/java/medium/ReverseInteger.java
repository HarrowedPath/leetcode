package medium;

public class ReverseInteger {
    public static void main(String[] args) {
        int expectedOutput = -321;
        assert expectedOutput == new ReverseInteger().reverse(1534236469);
    }

    public int reverse (int x) {
        long finalNum = 0;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum += lastDig;
            finalNum *= 10;
            x /= 10;
        }
        finalNum /= 10;
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) finalNum;
    }
}

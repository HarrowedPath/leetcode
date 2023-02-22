package easy;

public class HammingDistance {
    public static void main(String[] args) {
        int expectedOutput = 2;
        assert expectedOutput == new HammingDistance().hammingDistance(1, 4);
        assert expectedOutput == new HammingDistance().xor(1, 4);
    }

    public int xor(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        while (xor > 0) {
            count += xor & 1;
            xor >>>= 1;
        }
        return count;
    }
}

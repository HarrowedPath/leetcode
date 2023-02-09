package easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] expectedOutput = new int[]{9, 9, 0, 0};
        assert Arrays.equals(expectedOutput, new PlusOne().plusOne(new int[]{9, 8, 9, 9}));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
package easy;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public static void main(String[] args) {
        int output1 = 52;
        int output2 = 13;

        assert output1 == new MinimumSumOfFourDigitNumberAfterSplittingDigits().minimumSum(2932);
        assert output2 == new MinimumSumOfFourDigitNumberAfterSplittingDigits().minimumSum(4009);
    }

    public int minimumSum(int num) {
        int[] digits = new int[4];
        int i=0;
        while(i<=3) {
            digits[i++] = num%10;
            num/=10;
        }
        Arrays.sort(digits);
        return digits[0]*10+digits[2]+digits[1]*10+digits[3];
    }
}

package easy;

import java.util.Arrays;

public class RunningSumOf1dArray {
    public static void main(String[] args) {
        assert Arrays.equals(
                new RunningSumOf1dArray().bruteForce(new int[] {1,2,3,4}),
                new int[] {1,3,6,10}
        );

        assert Arrays.equals(
                new RunningSumOf1dArray().runningSum(new int[] {1,2,3,4}),
                new int[] {1,3,6,10}
        );
    }

    public int[] bruteForce(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

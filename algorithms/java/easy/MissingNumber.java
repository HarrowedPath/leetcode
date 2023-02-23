package easy;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int expectedOutput = 8;
        assert expectedOutput == new MissingNumber().bruteForce(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        assert expectedOutput == new MissingNumber().calculateSum(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    public int bruteForce(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int calculateSum(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}

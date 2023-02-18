package medium;

import java.util.Arrays;

@SuppressWarnings("all")
public class HouseRobber {
    public static void main(String[] args) {
        int expectedOutput = 4;
        assert expectedOutput == new HouseRobber().iterative(new int[]{1, 2, 3, 1});
        assert expectedOutput == new HouseRobber().recursiveBottomUp(new int[]{1, 2, 3, 1});
        assert expectedOutput == new HouseRobber().recursiveTopDown(new int[]{1, 2, 3, 1});
    }

    public int iterative(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    int[] memo;

    public int recursiveBottomUp(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return recursiveBottomUp(nums, 0);
    }

    private int recursiveBottomUp(int[] nums, int i) {
        if (i > nums.length - 1) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        var max = Math.max(recursiveBottomUp(nums, i + 2) + nums[i], recursiveBottomUp(nums, i + 1));
        memo[i] = max;
        return max;
    }

    public int recursiveTopDown(int nums[]) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return recursiveTopDown(nums, nums.length - 1);
    }

    private int recursiveTopDown(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        var max = Math.max(recursiveBottomUp(nums, i - 2) + nums[i], recursiveBottomUp(nums, i - 1));
        memo[i] = max;
        return max;
    }
}

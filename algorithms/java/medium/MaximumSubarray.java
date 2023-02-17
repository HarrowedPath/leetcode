package medium;

public class MaximumSubarray {
    public static void main(String[] args) {
        int expectedOutput = 6;
        assert expectedOutput == new MaximumSubarray().kadaneAlgorithm(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assert expectedOutput == new MaximumSubarray().dp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assert expectedOutput == new MaximumSubarray().bruteForceLimitedTimeExceed(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public int dp(int[] nums) {
        int[] storage = new int[nums.length];
        int max = nums[0];
        storage[0] = max;
        for (int i = 1; i < nums.length; i++) {
            storage[i] = Math.max(storage[i - 1] + nums[i], nums[i]);
            if (storage[i] > max) {
                max = storage[i];
            }
        }
        return max;
    }

    public int kadaneAlgorithm(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int bruteForceLimitedTimeExceed(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length - 1; j++) {
                currentSum += nums[j];
                if (currentSum > sum) {
                    sum = currentSum;
                }
            }
        }
        return sum;
    }
}

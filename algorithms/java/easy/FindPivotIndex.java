package easy;

public class FindPivotIndex {
    public static void main(String[] args) {
        int output = new FindPivotIndex().bruteForce(new int[]{1, 7, 3, 6, 5, 6});
        int output1 = new FindPivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        assert 3 == output;
        assert 3 == output1;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public int bruteForce(int[] nums) {
        int rightSum;
        int leftSum;
        for (int i = 0; i < nums.length; i++) {
            rightSum = 0;
            leftSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                leftSum += nums[j];
            }
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }
}

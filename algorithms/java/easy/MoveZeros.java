package easy;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] output = new int[]{0, 1, 0, 3, 12};
        new MoveZeros().moveZeros(output);
        int[] expectedOutput = new int[]{1, 3, 12, 0, 0};
        assert Arrays.equals(output, expectedOutput);
    }

    public void moveZeros(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, k++);
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

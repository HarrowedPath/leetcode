package medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] output = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(output, 3);
        int[] expectedOutput = new int[]{5, 6, 7, 1, 2, 3, 4};
        assert Arrays.equals(output, expectedOutput);
    }

    public void rotate(int[] nums, int k) {
        int rotation = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, rotation - 1);
        rotate(nums, rotation, nums.length - 1);
    }

    private void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

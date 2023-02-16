package easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] expectedOutput = new int[]{1, 2, 2, 3, 5, 6};
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new MergeSortedArray().bestSolution(nums1, 3, nums2, 3);
        assert Arrays.equals(nums1, expectedOutput);
    }

    public void mostEasyToCode(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    public void bestSolution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i--];
            } else {
                nums1[i + j + 1] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
    }
}
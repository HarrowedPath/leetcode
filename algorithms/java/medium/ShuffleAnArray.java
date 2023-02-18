package medium;

import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;
    private int[] original;
    private Random rand = new Random();

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        original = nums.clone();
    }

    public int[] reset() {
        nums = original;
        original = original.clone();
        return nums;
    }


    public int[] shuffle() {
        for (int i = nums.length - 1; i > 0; --i) {
            int j = rand.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

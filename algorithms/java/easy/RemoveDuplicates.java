package easy;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int output1 = new RemoveDuplicates().removeDuplicates1(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        int output2 = new RemoveDuplicates().removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        assert 5 == output1;
        assert 5 == output2;
    }

    public int removeDuplicates1(int[] nums) {
        int k = nums.length;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            } else if (nums[i] == nums[i + 1]) {
                k--;
            }
        }
        return k;
    }

    public int removeDuplicates2(int[] nums) {
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > temp) {
                temp = nums[i];
                nums[count] = temp;
                count++;
            }
        }
        return count;
    }
}


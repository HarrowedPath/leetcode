package easy;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int expectedOutput = 4;
        assert expectedOutput == new SingleNumber().bitManipulationXOR(new int[] {1,2,1,2,4});
        assert expectedOutput == new SingleNumber().bruteForce(new int[] {1,2,1,2,4});
    }

    public int bitManipulationXOR(int[] nums) {
        int ans=0;
        //since XOR with 0 returns same number
        //a XOR a = 0
        //XOR is associative (like sum)
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int bruteForce(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i+1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

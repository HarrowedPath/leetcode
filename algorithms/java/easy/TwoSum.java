package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        assert Arrays.equals(
                new TwoSum().bruteForce(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1}
        );
        assert Arrays.equals(
                new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1}
        );
    }

    public int[] twoSum (int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                i1 = map.get(target - nums[i]);
                i2 = i;
                break;
            }
            map.put(nums[i], i);
        }
        return new int[]{i1, i2};
    }

    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

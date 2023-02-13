package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        boolean expectedOutput = false;
        assert expectedOutput == new ContainsDuplicate().containsDuplicateStream(new int[]{1, 2, 3, 4});
        assert expectedOutput == new ContainsDuplicate().containsDuplicateHashSet(new int[]{1, 2, 3, 4});
        assert expectedOutput == new ContainsDuplicate().containsDuplicateHashMap(new int[]{1, 2, 3, 4});
        assert expectedOutput == new ContainsDuplicate().XORBasedApproach(new int[]{1, 2, 3, 4});
    }

    public boolean containsDuplicateStream(int[] nums) {
        var count = Arrays.stream(nums)
                .distinct()
                .count();
        return count != nums.length;
    }

    public boolean containsDuplicateHashSet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public boolean containsDuplicateHashMap(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                return true;
            else
                hm.put(nums[i], i);
        }
        return false;
    }

    public boolean XORBasedApproach(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] ^ nums[i + 1]) == 0) {
                return true;
            }
        }
        return false;
    }
}

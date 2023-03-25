package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int expectedOutput = 2;
        assert expectedOutput == new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.compute(e, (k, v) -> v == null ? 1 : ++v);
            if (map.get(e) > (nums.length - 1) / 2) {
                return e;
            }
        }
        return 0;
    }
}

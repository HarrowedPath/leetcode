package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] expectedOutput = new int[]{2, 2};
        assert Arrays.equals(expectedOutput, new IntersectionOfTwoArraysII().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> tempList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            map.compute(value, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                map.computeIfPresent(j, (k, v) -> --v);
                tempList.add(j);
            }
        }
        int[] resultArray = new int[tempList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = tempList.get(i);
        }
        return resultArray;
    }

}

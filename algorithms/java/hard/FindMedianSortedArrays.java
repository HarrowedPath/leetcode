package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        double output = new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        double output1 = new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assert 2.00000 == output;
        assert 2.50000 == output1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>(convert(Arrays.asList(nums1, nums2)));
        Collections.sort(result);
        if (result.size() % 2 == 1) {
            return result.get(result.size() / 2);
        } else {
            return (result.get(result.size() / 2) + result.get(result.size() / 2 - 1)) / 2.0;
        }
    }

    public static List<Integer> convert(List<int[]> list) {
        return list.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .toList();
    }
}

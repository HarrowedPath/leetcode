package medium;

import java.util.*;

public class DescribeThePainting {
    public static void main(String[] args) {
        List<List<Long>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.asList(1L, 4L, 14L));
        expectedOutput.add(Arrays.asList(4L, 7L, 16L));
        assert expectedOutput.equals(new DescribeThePainting().splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}}));
    }

    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Long, Long> map = new TreeMap<>();

        for (int[] segment : segments) {
            map.compute((long) segment[0], (k, v) -> (v == null) ? segment[2] : v + segment[2]);
            map.compute((long) segment[1], (k, v) -> (v == null) ? -segment[2] : v - segment[2]);
        }

        List<List<Long>> result = new ArrayList<>();

        long prev = 0;
        long sum = 0;

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (sum != 0) {
                result.add(Arrays.asList(prev, entry.getKey(), sum));
            }

            sum += map.get(entry.getKey());
            prev = entry.getKey();
        }
        return result;
    }
}

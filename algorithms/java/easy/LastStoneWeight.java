package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int output = new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        int output1 = new LastStoneWeight().forSmallSetsAndIfArrayOnlyForRead(new int[]{2, 7, 4, 1, 8, 1});
        assert 1 == output;
        assert 1 == output1;
    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            queue.add(i);
        }
        int x;
        int y;
        while (queue.size() > 1) {
            y = queue.poll();
            x = queue.poll();
            if (y > x) {
                queue.offer(y - x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public int forSmallSetsAndIfArrayOnlyForRead(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}

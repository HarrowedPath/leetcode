package easy;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int output = new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        int output1 = new MinCostClimbingStairs().whenArrayOnlyForRead(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        assert 6 == output;
        assert 6 == output1;
    }

    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        if (cost.length == 2) {
            return Math.min(first, second);
        }
        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    public int whenArrayOnlyForRead(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}

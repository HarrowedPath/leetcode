package medium;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int expectedOutput = 7;
        assert expectedOutput == new BestTimeToBuyAndSellStockII().maxProfits(new int[]{
                7, 1, 5, 3, 6, 4
        });
    }

    public int maxProfits(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}

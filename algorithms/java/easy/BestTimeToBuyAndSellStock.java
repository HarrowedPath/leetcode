package easy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int output = new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        int output1 = new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 6, 4, 3, 1});
        assert 5 == output;
        assert 0 == output1;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        int todayProfit;

        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            todayProfit = price - min;
            if (maxProfit < todayProfit) {
                maxProfit = todayProfit;
            }
        }
        return maxProfit;
    }
}

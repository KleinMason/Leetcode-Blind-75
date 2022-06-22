package Best_Time_to_Buy_and_Sell_Stock;

public class solution {
    /**
     * First solution: Accepted
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }
}

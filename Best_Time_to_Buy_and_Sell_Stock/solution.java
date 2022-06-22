package Best_Time_to_Buy_and_Sell_Stock;

/**
 * NOTE: Track lowest possible buy and highest
 * possible sell **profit**. Modified two-pointer
 * solution.
 */

public class solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }
}

package Grind_75.Week_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class solution {

    // 1. Two Sum: https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[] { map.get(diff), i };
            map.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }

    // 121. Best Time to Buy and Sell Stock:
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }

    // 57. Insert Interval: https://leetcode.com/problems/insert-interval/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            res.add(intervals[i++]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[] { start, end });
        while (i < intervals.length) 
            res.add(intervals[i++]);
        return res.toArray(new int[res.size()][]);
    }
}

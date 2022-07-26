package Week_1_Sequences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class solution {
    public static void main(String[] args) {

    }

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

    // 217. Contains Duplicate: https://leetcode.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
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

    // 242. Valid Anagram: https://leetcode.com/problems/valid-anagram/
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (char l : s.toCharArray())
            alphabet[l - 'a']++;
        for (char l : t.toCharArray())
            alphabet[l - 'a']--;
        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }

    // 20. Valid Parentheses: https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (stack.empty())
                return false;
            else if (c == ')' && stack.pop() != '(')
                return false;
            else if (c == ']' && stack.pop() != '[')
                return false;
            else if (c == '}' && stack.pop() != '{')
                return false;
        }
        return stack.empty();
    }

    // 53. Maximum Subarray: https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSumSoFar = Integer.MIN_VALUE;
        for (int num : nums) {
            currentSum += num;
            maxSumSoFar = Math.max(currentSum, maxSumSoFar);
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSumSoFar;
    }

    // 238. Product of Array Except Self:
    // https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            answer[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            answer[i] *= tmp;
            tmp *= nums[i];
        }
        return answer;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

}

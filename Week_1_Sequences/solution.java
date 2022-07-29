package Week_1_Sequences;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.print.attribute.ResolutionSyntax;

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

    // 15. 3Sum: https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // skip duplicates
            int j = i + 1, k = nums.length - 1, target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1])
                        j++; // skip duplicates
                    while (j < k && nums[k] == nums[k + 1])
                        k--; // skip duplicates
                } else if (nums[j] + nums[k] < target)
                    j++;
                else
                    k--;
            }
        }
        return res;
    }

    // 56. Merge Intervals: https://leetcode.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int lo = intervals[0][0], hi = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= hi) {
                hi = Math.max(intervals[i][1], hi);
            } else {
                res.add(new int[] { lo, hi });
                lo = intervals[i][0];
                hi = intervals[i][1];
            }
        }
        res.add(new int[] { lo, hi });
        return res.toArray(new int[0][]);
    }

    // 49. Group Anagrams: https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray())
                ca[c - 'a']++;
            String keyString = String.valueOf(ca);
            if (!map.containsKey(keyString))
                map.put(keyString, new ArrayList<>());
            map.get(keyString).add(s);
        }
        System.out.println(map.keySet().); 
        return new ArrayList<>(map.values());
    }

}

package Grind_75.Week_1;

import java.util.HashMap;
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

    // 20. Valid Parentheses: https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            if (stack.isEmpty()) return false;
            else if (c == ')' && stack.pop() != '(')
                return false;
            else if (c == '}' && stack.pop() != '{')
                return false;
            else if (c == ']' && stack.pop() != '[')
                return false;
        }
        return stack.isEmpty();
    }

    // 21. Merge Two Sorted Lists: https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;
        return head.next; 
    }

    // 121. Best Time to Buy and Sell Stock: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }

    // 125. Valid Palindrome: https://leetcode.com/problems/valid-palindrome/
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

}

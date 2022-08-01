package Week_2_Data_Structures;

public class solution {
    public static void main(String[] args) {

    }

    // 206. Reverse Linked List: https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        /* Iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    // public ListNode reverseList(ListNode head) {
    //     /* Recursive solution */
    //     return _reverseList(head, null);
    // }

    // private ListNode _reverseList(ListNode head, ListNode newHead) {
    //     if (head == null)
    //         return newHead;
    //     ListNode next = head.next;
    //     head.next = newHead;
    //     return _reverseList(next, head);
    // }

    // 141. Linked List Cycle: https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 11. Container With Most Water: https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int maxVolume = 0, lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int w = Math.min(height[lo], height[hi]);
            int l = hi - lo;
            int area = w * l;
            maxVolume = Math.max(maxVolume, area);
            if (height[lo] > height[hi])
                hi--;
            else 
                lo++;
        }
        return maxVolume;
    }

    // 153. Find Minimum in Rotated Sorted Array: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[lo];
    }
    
}

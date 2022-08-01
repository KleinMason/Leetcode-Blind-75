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
}
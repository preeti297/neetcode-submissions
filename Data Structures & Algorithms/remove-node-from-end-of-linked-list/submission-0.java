/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;

        while(n > 0 && fast != null)
        {
            fast = fast.next;
            n--;
        }

        ListNode prev = new ListNode(-1);
        ListNode slow = head;

        while(fast != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;

        return prev.val == -1 ? prev.next : head;

    }
}

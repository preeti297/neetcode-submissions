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

 /* Intuition -  1. Move fast pointer upto n
 2. then use slow pointer and fast pointer and move l-n distance
 3. then remove slow pointer
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(n > 0)
        {
            fast = fast.next;
            n--;
        }

        if(fast == null)
            return head.next;

        while(fast != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;

        }

        

        if(slow != null)
            prev.next = slow.next;
        else
            prev.next = slow;

        return head;

    }
}

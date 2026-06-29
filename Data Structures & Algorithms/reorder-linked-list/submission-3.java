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
    public void reorderList(ListNode head) {

        if(head.next == null)
            return;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null)
            prev.next = null;
        
        if(slow != null)
            slow = reverse(slow);

        
        ListNode mergedHead = new ListNode(0);
        ListNode newNode = mergedHead;

        while(slow != null && head != null)
        {
            newNode.next = head;
            head = head.next;
            newNode = newNode.next;
            newNode.next = slow;
            slow = slow.next;
            newNode = newNode.next;
            
        }

        if(slow != null)
        {
            newNode.next = slow;
        }
        else if(head != null)
        {
            newNode.next = head;
        }

        head = mergedHead.next;

        
    }

    public ListNode reverse(ListNode slow)
    {
        ListNode curr = slow;
        ListNode prev = null;
        ListNode nxt = null;

        while(curr != null)
        {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
        
    }
}

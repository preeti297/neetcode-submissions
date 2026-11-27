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
 //intuition - Find the kth node and reverse the group

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode newList = new ListNode(-1,head);
        ListNode groupPrev = newList;

        while(true)
        {
            ListNode kth = getKthNode(groupPrev,k);

            if(kth == null)
                break;

            ListNode groupNext = kth.next;

            //Reverse the group
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            while(curr != groupNext)
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;

            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;

        }

        return newList.next;

        
    }

    public ListNode getKthNode(ListNode curr, int k)
    {

        while(curr != null && k > 0)
        {
            curr = curr.next;
            k--;
        }

        return curr;

    }
}

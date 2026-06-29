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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedList = new ListNode(-101);
        ListNode currentMerged = mergedList;

        while(list1 != null && list2 != null)
        {
            ListNode newNode;
            if(list1.val < list2.val)
            {
                newNode = new ListNode(list1.val);
                list1 = list1.next;
            }
            else
            {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            }
            currentMerged.next = newNode;
            currentMerged = currentMerged.next;
        }

        if(list1!= null)
        {
            currentMerged.next = list1;
        }
        else
        {
            currentMerged.next = list2;
        }

        return mergedList.next;    
    }
}
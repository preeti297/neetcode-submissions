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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode addedList = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        addedList.next = temp;
        int sum = 0;
        int carry = 0;

        while(l1 != null || l2 != null)
        {
            int op1 = 0 , op2 = 0;

            if(l1 != null)
            {
                op1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                op2 = l2.val;
                l2 = l2.next;
            }

            sum = (op1 + op2);

            int newVal = (sum + carry)%10;

            System.out.println(op1 + ":" + op2);
            System.out.println(sum + ":" + carry);

            temp.next = new ListNode(newVal);
            temp = temp.next;

            carry = (sum+carry)/10;
            

        }

        System.out.println(carry);

        if(carry != 0)
        {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }

        return addedList.next.next;
        
    }
}

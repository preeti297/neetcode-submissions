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

 //Intuition use minHeap to merge it to a resultant node

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>()
        {

            public int compare(ListNode node1, ListNode node2)
            {
                return node1.val - node2.val;
            }

        });

        if(lists == null)
            return null;

        for(ListNode list : lists)
        {
            if(list != null)
                minHeap.offer(list);
        }

        ListNode mergedList = new ListNode(-1);
        ListNode temp = mergedList;

        while(!minHeap.isEmpty())
        {
            ListNode newNode = minHeap.poll();

            temp.next = newNode;

            temp = temp.next;

            newNode = newNode.next;

            if(newNode != null)
                minHeap.offer(newNode);
        }

        return mergedList.next;

    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums)
        {
            queue.offer(num);
        }

        int i = 0 ;

        while(i < k - 1)
        {
            queue.poll();
            i++;
        }

        return queue.poll();
        
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones)
        {
            queue.offer(stone);
        }

        while(!queue.isEmpty())
        {
            if(queue.size() == 1)
                return queue.peek();
                
            int weight1 = queue.poll();
            int weight2 = queue.poll();

            if(weight2 < weight1)
            {
                queue.offer(weight1 - weight2);
            }

            

        }

        return 0;
        
    }
}

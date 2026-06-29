class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {

        if(!minHeap.isEmpty() && num > minHeap.peek())
        {
            minHeap.offer(num);
        }
        else
        {
            maxHeap.offer(num);
        }

        //Balance

        while(Math.abs(minHeap.size() - maxHeap.size()) > 1)
        {
            if(minHeap.size() > maxHeap.size())
            {
                maxHeap.offer(minHeap.poll());
            }
            else
            {
                minHeap.offer(maxHeap.poll());
            }
        }
        
    }
    
    public double findMedian() {

        int even = (minHeap.size() + maxHeap.size())%2;

        if(even == 0)
        {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
        else
        {
            if(minHeap.size() > maxHeap.size())
            {
                return minHeap.peek();
            }
            else
            {
                return maxHeap.peek();
            }

        }
        
    }
}

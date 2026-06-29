class KthLargest {

    int k;
    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {

        this.heap = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;

        for(int num : nums)
        {
            this.heap.offer(num);
        }
        
    }
    
    public int add(int val) {

        this.heap.offer(val);

        int i = 1;

        List<Integer> nums = new ArrayList<>();

        while(i < k)
        {
            nums.add(this.heap.poll());
            i++;
        }
        
        int kLargest = this.heap.poll();

        for(int num : nums)
        {
            this.heap.offer(num);
        }

        this.heap.offer(kLargest);

        return kLargest;
    }
}

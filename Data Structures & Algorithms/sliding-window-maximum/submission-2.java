class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    List<Integer> maxValues = new ArrayList<>();

    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    int i;

    for(i = 0 ; i < k ; i++)
    {
        queue.add(nums[i]);
    }

    maxValues.add(queue.peek());

    for( ; i < nums.length ; i++)
    {
        int index = i - k;

        queue.remove(nums[index]);

        queue.add(nums[i]);

        maxValues.add(queue.peek());
    }

    int[] ans = new int[maxValues.size()];

    int j = 0;

    for(int num : maxValues)
    {
        ans[j] = num;
        j++;
    }


    return ans;  
    }
}

class Solution {
    public int maxSubArray(int[] nums) {

        /*
        Intuition - Brute force -  find sum of every subarray, but we dont have to calculate every subarray, that repetitive work, instead find max at i so we have maximum at the end of i
        */

        int sum = 0, mx = Integer.MIN_VALUE;

        for(int num : nums)
        {
            

            if(sum < 0)
            {
                sum = 0;
            }

            sum += num;

            mx = Math.max(sum, mx);

        }

        return mx;
        
    }
}

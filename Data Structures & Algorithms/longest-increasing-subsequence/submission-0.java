class Solution {
    public int lengthOfLIS(int[] nums) {

        /*
        Memoization - recursion compare with every other element and store values at index to avoid recomputation
        */

        int l = nums.length;
        int[] memo = new int[l];
        for(int i = 0 ; i < l ; i++)
        {
            memo[i] = -1;
        }

        int best = 0;

        for(int start = 0 ; start < l ;start++)
        {
            best = Math.max(best, 1 + helper(start, nums, memo));
        }

        return best;
        
    }

    private int helper(int index, int[] nums, int[] memo)
    {
        if(index == nums.length - 1)
            return 0;
        
        if(memo[index] != -1)
            return memo[index];

        int mx = 0;

        for(int i = index +1 ; i < nums.length ; i++)
        {
            if(nums[index] < nums[i])
                mx = Math.max(mx, 1 + helper(i, nums, memo));
        }

        memo[index] = mx;

        return memo[index];
    }
}

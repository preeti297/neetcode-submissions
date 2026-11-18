class Solution {
    public boolean canPartition(int[] nums) {

        /*
        recursion - memoization - check which combination of number givens totalsum/2; and memo will be index and sum from that index
        */

        int total = 0;

        for(int num : nums)
            {
                total += num;
            }
        
        if(total%2 != 0)
            return false;
    
        int target = total/2;

        Boolean[][] memo = new Boolean[nums.length+1][target+1];

        return helper(0,0,target,nums,memo);
   
    }

    private boolean helper(int index, int sum, int target, int[] nums, Boolean[][] memo)
    {
        if(sum == target)
            return true;
        
        if(memo[index][sum] != null)
            return memo[index][sum];
        
        for(int i = index ; i < nums.length ; i++)
        {
            if(sum + nums[i] <= target && helper(i+1, sum + nums[i], target, nums, memo))
            {
                memo[index][sum] = true;
                return true;
            }
        }

        memo[index][sum] = false;
        return false;
    }
}

class Solution {
    public int jump(int[] nums) {

        int[] memo = new int[nums.length];

        return recursion(nums, 0, memo);
        
    }

    private int recursion(int[] nums, int pos, int[] memo)
    {
        
        int minCount = Integer.MAX_VALUE;

        if(pos >= nums.length - 1)
            return 0;
        
        if(memo[pos] != 0)
            return memo[pos];

        for(int p = 1 ; p <= nums[pos] ; p++)
        {

        int res = recursion(nums, pos + p, memo);

        if(res != Integer.MAX_VALUE)
        {
            minCount = Math.min(minCount, 1 + res);
        }

        }

        memo[pos] = minCount;

        return  memo[pos];
    }
    
}

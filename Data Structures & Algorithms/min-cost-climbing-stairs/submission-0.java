class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        memo = new int[n];

        return Math.min(helper(cost,0), helper(cost,1));
        
    }

    public int helper(int[] cost, int index)
    {

        if(index >= cost.length)
        {
            return 0;
        }

        if(memo[index] != 0)
            return memo[index];
        
        memo[index] = cost[index] + Math.min(helper(cost,index+1), helper(cost, index+2));

        return memo[index];
    }
}

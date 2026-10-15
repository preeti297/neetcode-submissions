class Solution {
    int[] memo;
    public int climbStairs(int n) {

        memo = new int[n+1];
        memo[1] = 1;
        if(n > 1)
            memo[2] = 2;

        memo[n] = helper(n);

        return memo[n];


    }

    public int helper(int n)
    {
        if(memo[n] != 0)
            return memo[n];
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        memo[n] = helper(n-1) + helper(n-2);
        return memo[n];
    }
}

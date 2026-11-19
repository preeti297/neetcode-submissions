class Solution {
    public int change(int amount, int[] coins) {
        
        int l = coins.length;

        Integer[][] memo = new Integer[l][amount+1];

        return dfs(0, amount, coins, memo);
    }

    private int dfs(int index, int amount, int[] coins, Integer[][] memo)
    {
        if(amount == 0)
            return 1;

        if(amount < 0)
            return 0;
        
        if(memo[index][amount] != null)
            return memo[index][amount];
        
        int res = 0;
        for(int i = index ; i < coins.length ; i++)
        {
          res += dfs(i, amount - coins[i], coins, memo);  
        }
        memo[index][amount] = res;

        return memo[index][amount];
    }
}

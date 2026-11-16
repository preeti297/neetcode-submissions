class Solution {
    int minCost;
    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount+1];

        for(int i = 0 ; i < amount + 1 ; i++)
            memo[i] = -2;

        return helper(coins, amount, memo);
        
    }

    private int helper(int[] coins, int amount, int[] memo)
    {

        if(amount < 0)
            return -1;
        
    
        if(amount == 0)
        {
            return 0;
        }

         if(memo[amount] != -2)
            return memo[amount];

        int bestCoins = Integer.MAX_VALUE;

        for(int coin : coins)
        {
            int ret = helper(coins, amount-coin, memo);

            if(ret >= 0)
            {
                bestCoins = Math.min(bestCoins, ret + 1);
            }

           
        }

        memo[amount] = (bestCoins == Integer.MAX_VALUE) ? -1 : bestCoins;

        return memo[amount];


    }
}

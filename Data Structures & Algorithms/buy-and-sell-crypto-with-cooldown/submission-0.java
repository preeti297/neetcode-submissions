class Solution {
    public int maxProfit(int[] prices) {

        int l = prices.length;

        int best = 0;

        int[] memo = new int[l];

        for(int i = 0 ; i < l ; i++)
        {
            memo[i] = -1;
        }

        for(int i = 0 ; i < l ; i++)
        {
            best = Math.max(best, dfs(i, prices,memo));
        }

        return best;
        
    }

    private int dfs(int index, int[] prices, int[] memo)
    {
        if(index == prices.length)
            return 0;
        
        if(memo[index] != -1)
            return memo[index];
        
        int best = 0;
        
        for(int i = index + 1; i < prices.length ; i++)   // CHANGED: index + 2 → index + 1
        {
            if(prices[i] >  prices[index])
            {
            int next = 0;                                  // CHANGED: added
            for(int j = i + 2; j < prices.length; j++)     // CHANGED: added — next buy after cooldown
            {
                next = Math.max(next, dfs(j, prices, memo));
            }

            int profit = (prices[i] - prices[index]) + next;   // CHANGED: dfs(i) → next
            best = Math.max(best, profit);
            }
            
        }

        memo[index] = best;

        return memo[index];
    }
}
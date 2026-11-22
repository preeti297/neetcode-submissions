class Solution {
    public int maxProfit(int[] prices) {

        /*Keep track of minPrice and if a price is greater than minPrice then find profit if not update the minPrice*/

        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0 ; i < prices.length ; i++)
        {
            if(prices[i] < buyPrice)
                buyPrice = prices[i];
            else
            {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }

        return maxProfit;
        
    }
}

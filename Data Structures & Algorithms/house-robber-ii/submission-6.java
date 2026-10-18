
class Solution {
    int[][] memo;
    public int rob(int[] nums) {

        int l = nums.length;

        if (l == 1) return nums[0];

        memo = new int[l][2];

         for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }

        int maxProfit = helper(nums,0,1);
        

        

for (int s = 1; s < l; s++)                 // starts 1 and 2 are enough, but this is simplest
    maxProfit = Math.max(maxProfit, helper(nums, s, 0));
return maxProfit;
        
    }

    public int helper(int[] nums, int index, int flag)
    {
        if(index >= nums.length || (flag == 1 && index == nums.length -1))
        return 0;

        if(memo[index][flag] != -1)
            return memo[index][flag];

        int sum = 0;

        for(int i = index + 2; i < nums.length ; i++)
        {
            sum = Math.max(sum, helper(nums, i, flag));
        }

        memo[index][flag] = sum + nums[index];

        return memo[index][flag];
    }
}

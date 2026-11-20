class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        Map<List<Integer>, Integer> memo = new HashMap<>();

        return helper(0, 0, nums, target, memo);
        
    }

    private int helper(int index, int sum, int[] nums, int target, Map<List<Integer>, Integer> memo)
    {
        if(index == nums.length)
        {
            if(sum == target)
                return 1;
            else
                return 0;

        }

        if(memo.containsKey(List.of(index,sum)))
            return memo.get(List.of(index,sum));
        
        int ways = 0;
        
         ways += helper(index+1, sum + nums[index], nums, target, memo) + helper(index+1, sum - nums[index], nums, target, memo);

         memo.put(List.of(index,sum), ways);

        return memo.get(List.of(index,sum));
    }
}

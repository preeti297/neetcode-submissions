class Solution {
    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int best = helper(nums, 0);
        if (nums.length > 1) best = Math.max(best, helper(nums, 1));
        return best;
    }

    // max profit if we rob house i, then choose optimally from i+2 onward
    private int helper(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];

        int bestAfter = 0;
        for (int j = i + 2; j < nums.length; j++) {
            bestAfter = Math.max(bestAfter, helper(nums, j));
        }
        memo[i] = nums[i] + bestAfter;
        return memo[i];
    }
}
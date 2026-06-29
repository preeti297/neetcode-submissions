class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> sumTracker = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(sumTracker.containsKey(nums[i]))
            {
                return new int[] { sumTracker.get(nums[i]), i};
            }

            sumTracker.put(target - nums[i], i);
        }

        return new int[] {};
        
    }
}

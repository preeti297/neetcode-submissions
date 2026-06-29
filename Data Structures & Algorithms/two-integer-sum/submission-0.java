class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> seen = new HashMap<>();

        int[] ans = new int[2];

        for(int i = 0 ; i < nums.length ; i++)
        {
            int second = target - nums[i];

            if(seen.containsKey(nums[i]))
            {
                ans[0] = seen.get(nums[i]);
                ans[1] = i;

                break;
            }
            else
            {
                seen.put(second, i);
            }
        }

        return ans;
        
    }
}

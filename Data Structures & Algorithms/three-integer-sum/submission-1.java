class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -1 * nums[i];

            int j = i + 1, k = nums.length - 1;

            

            while(j < k)
            {
                int sum = nums[j] + nums[k];

                if(sum == target)
                {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        result.add(ans);
                        j++;
                        k--;

                        while(nums[j] == nums[j-1] && j < k)
                            j++;
                }
                else if(sum > target)
                    k--;
                else
                    j++;
            }
        }

        return result;
        
    }
}

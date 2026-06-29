class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();

        for(int num : nums)
        {
            numSet.add(num);
        }

        int len = nums.length;
        int mxLength = 0;
        int start = 0;

        for(int i = 0 ; i < len ; i++)
        {
            int count = 0;
            if(!numSet.contains(nums[i] - 1))
            {
                start = nums[i];
            
                while(numSet.contains(start))
                {
                    count++;
                    start++;
                }


                mxLength = Math.max(mxLength, count);
            }
        }

        return mxLength;
        
    }
}

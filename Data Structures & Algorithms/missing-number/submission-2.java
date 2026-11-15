class Solution {
    public int missingNumber(int[] nums) {

        int l = nums.length;

        Arrays.sort(nums);

        for(int i = 0 ; i < l ; i++)
        {
            if(i != nums[i])
                return i;
        }

        return l;
        
    }
}

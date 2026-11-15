class Solution {
    public int missingNumber(int[] nums) {

        int l = nums.length;

        int num = l;

        for(int i = 0 ; i < l ; i++)
        {
            num ^= i ^ nums[i];
        }

        return num;
        
    }
}

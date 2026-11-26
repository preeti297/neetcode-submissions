class Solution {
    public int findDuplicate(int[] nums) {

        /*
        
        Since numbers are stored from 1 to n+1 - 
        if a number is repeated more than once then the number - 1 acts as index  - so replace that number with nums[index] * -1, if repeated then number at the index will be negative 
        
        */

        int i;

        for(i = 0 ; i < nums.length ; i++)
        {
            int index = Math.abs(nums[i]) - 1;


            if(nums[index] < 0)
            {
                return index + 1;
            }
            else
            {
                nums[index] *= -1;
            }
        }

        return -1;
        
    }
}

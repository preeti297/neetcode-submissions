class Solution {
    public int findDuplicate(int[] nums) {

        int i;

        for(i = 0 ; i < nums.length ; i++)
        {
            int index = Math.abs(nums[i]) - 1;

            System.out.println(i + " : " + nums[i] +":" +index);

            if(nums[index] < 0)
            {
                return Math.abs(nums[i]);
            }
            else
            {
                nums[index] *= -1;
            }
        }

        return -1;
        
    }
}

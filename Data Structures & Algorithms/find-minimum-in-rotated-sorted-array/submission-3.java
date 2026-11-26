class Solution {
    public int findMin(int[] nums) {

        //Intuition - Find the index where the it was rotated

        int len = nums.length;

        int left = 0, right = len - 1;

        if(nums[left] <= nums[right])
            return nums[left];

        while(left <= right)
        {
            int mid = (left + right)/2;

            if(mid < len && nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(mid > 0 && nums[mid-1] > nums[mid])
                return nums[mid];

            if(nums[mid] > nums[left])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }

        return nums[0];
        
    }
}

class Solution {
    public int search(int[] nums, int target) {

        int pivotIndex = 0;

        int len = nums.length;

        int left = 0, right = len - 1;

        while(left < right)
        {
            int mid = (left + right)/2;

            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        int index = binarySearch(nums, target, left, len - 1);

        if(index != -1)
            return index;
        
        int finalIndex = binarySearch(nums, target, 0, left - 1);

        return finalIndex;
        
    }

    public int binarySearch(int[] nums, int target, int l, int r)
    {
        while(l <= r)
        {
            int mid = (l + r)/2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        return -1;

    }
}

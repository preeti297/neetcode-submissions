class Solution {
    public int search(int[] nums, int target) {

        int l = nums.length;

        int pivotIndex = -1;

        int left = 0, right = l-1;

        while(left < right)
        {
            int mid = (left + right)/2;

            if(mid < l-1 && nums[mid] > nums[mid+1])
            {
             pivotIndex = mid + 1;
             break;
            }

            if(nums[left] < nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        if(pivotIndex == -1)
            pivotIndex = left;

        System.out.println(pivotIndex);

        int index = binarySearch(nums, 0, pivotIndex-1, target);

        //System.out.println(index);

        if(index != -1)
        {
            return index;
        }

        return binarySearch(nums, pivotIndex, l-1, target);

    }

    private int binarySearch(int[] nums, int left, int right, int target)
    {

        while(left <= right)
        {
            int mid = (left + right)/2;

            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid -1;
        }

        return -1;
    }

}

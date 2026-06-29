class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int nr = matrix.length;
        int nc = matrix[0].length;

        int row = 0;

        while(row < nr)
        {
            int[] rw = matrix[row];

            if(rw[0] <= target && rw[nc-1] >= target)
            {
                boolean found = binarySearch(rw,target,nc);
                if(found)
                    return true;
            }

            row++;
        }

        return false;
        
    }

    public boolean binarySearch(int[] nums, int target, int ln)
    {
        int left = 0, right = ln -1;

        while(left <= right)
        {
            int mid = (left + right) / 2;

            if(nums[mid] == target)
                return true;
            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }
}

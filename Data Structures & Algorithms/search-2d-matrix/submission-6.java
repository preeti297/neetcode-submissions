class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //Intuition - check if target is between the first and last element in the row, if yes - R*log(c) - starting version
        //Interview verison - flattened version

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while(left <= right)
        {

            int mid = (left + right)/2;

            int r = mid/cols, c = mid%cols; // for 1d number to 2d rows and cols

            if(matrix[r][c] == target)
                return true;
            
            if(target > matrix[r][c])
                left = mid + 1;
            else
                right = mid -1;




        }

        return false;

    }
}

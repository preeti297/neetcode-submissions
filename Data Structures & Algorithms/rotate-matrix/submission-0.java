class Solution {
    public void rotate(int[][] matrix) {

        /* Find transpose of the matrix and then reverse the rows*/

        int n = matrix.length;

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i+1 ; j < n ; j++)
            {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i = 0 ; i < n ; i++)
        {
            int l =0, r = n-1;

            while(l < r)
            {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }


        
    }
}

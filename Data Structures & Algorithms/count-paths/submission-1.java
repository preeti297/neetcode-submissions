class Solution {

    int[][] dirs = {{0,1},{1,0}};

    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for(int i = 0; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                memo[i][j] = -1;
            }
        }

        return helper(0,0,m,n,memo);
    
    }

    private int helper(int x, int y, int m, int n, int[][] memo)
    {
        if(x == m-1 && y == n-1)
            return 1;
        
        if(x >= m || y >=n)
            return 0;
        
        if(memo[x][y] != -1)
            return memo[x][y];
        
        memo[x][y] = helper(x,y+1,m,n,memo) + helper(x+1,y,m,n,memo);

       
       return memo[x][y];
        

    }


}

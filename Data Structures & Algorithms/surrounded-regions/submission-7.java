class Solution {
    int rows, cols;
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    int[][] visit;

    public void solve(char[][] board) {

        rows = board.length;
        cols = board[0].length;
        visit = new int[rows][cols];
        

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(board[i][j] == 'O')
                {
                    if(dfs(board, i, j))
                    {
                        board[i][j] = 'X';
                    }
                }
            }
        }
        
    }

    public boolean dfs(char[][] board, int row, int col)
    {
        boolean isSurronded = true;
        if(isBorder(board,row,col))
            return false;
        
        visit[row][col] = 1;
        

        for(int[] dir : dirs)
        {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            System.out.println(newRow + ":" + newCol);

            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && visit[newRow][newCol] == 0 && board[newRow][newCol] == 'O')
                isSurronded &= dfs(board,newRow,newCol);
                if(!isSurronded)
                {
                     break;
                }

            
        }
       
        visit[row][col] = 0;
        return isSurronded;
    }

    public boolean isBorder(char[][] board, int row, int col)
    {
        if((row == 0 || row == rows - 1 || col == 0 || col == cols - 1) && board[row][col] == 'O' )
            return true;
        return false;
    }
}

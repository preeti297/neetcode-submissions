class Solution {

    int rows, cols;
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {

        //DFS

         rows = board.length;
         cols = board[0].length;
        int[][] visited = new int[rows][cols];

        for(int i = 0 ; i < rows; i++)
        {
            for(int j = 0; j < cols ; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    System.out.println("Call" + i + ":" + j);
                    visited[i][j] = 1;
                    if(dfs(board, visited, i,j,word,1))
                        return true;
                    visited[i][j] = 0;
                }
            }
        }

        return false;
        
    }

    private boolean dfs(char[][] board, int[][] visited, int i, int j, String word, int index)
    {

        boolean result = false;

        if(index == word.length())
        {
            return true;
        }

        for(int[] dir : dirs)
        {
            int newX = dir[0] + i;
            int newY = dir[1] + j;

            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] == 0 && word.charAt(index) == board[newX][newY])
            {
                visited[newX][newY] = 1;
                result |= dfs(board, visited, newX, newY, word, index+1);
                visited[newX][newY] = 0;
            }
        }

        return result;
        
    }
}

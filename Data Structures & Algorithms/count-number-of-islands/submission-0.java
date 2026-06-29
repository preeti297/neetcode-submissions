class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;

        int nr = grid.length;
        int nc = grid[0].length;

        int[][] visited = new int[nr][nc];

        for(int i = 0 ; i < nr ; i++)
        {
            for(int j = 0 ; j < nc ; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    islands++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return islands;
        
    }

    public void dfs(char[][] grid, int[][] visited, int x, int y)
    {
        visited[x][y] = 1;

        int[][] dirs = {{0,1}, {1,0} , {0,-1}, {-1,0}};

        for(int[] dir : dirs)
        {
            int newX = dir[0] + x;
            int newY = dir[1] + y;

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1' && visited[newX][newY] == 0)
            {
                dfs(grid, visited, newX, newY);
            }
        }
    }
}

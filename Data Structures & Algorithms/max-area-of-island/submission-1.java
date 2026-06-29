class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = Integer.MIN_VALUE;
        int nr =  grid.length;
        int nc = grid[0].length;
        int[][] visited = new int[nr][nc];

        for(int i = 0 ; i < nr ; i++)
        {
            for(int j = 0 ; j < nc ; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == 0)
                {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j, 0));
                }
            }
        }

        return (maxArea == Integer.MIN_VALUE) ? 0 : maxArea;
        
    }

    public int dfs(int[][] grid, int[][] visited, int row, int col, int count)
    {

        visited[row][col] = 1;

        count ++;

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for(int[] dir : dirs)
        {
            int newX = dir[0] + row;
            int newY = dir[1] + col;

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1 && visited[newX][newY] == 0)
            {
                count = dfs(grid, visited, newX, newY, count);
            }
        }

        return count;
    }
}

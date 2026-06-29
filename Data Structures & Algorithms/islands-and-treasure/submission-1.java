class Solution {

    //bfs is better option

    int inf = 2147483647;
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int rows, cols;

    public void islandsAndTreasure(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(grid[i][j] == inf)
                {
                    grid[i][j] = bfs(grid, i, j);

                }
            }
        }
        
    }

    public int bfs(int[][] grid , int row, int col)
    {

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{row, col,0});
        int[][] visit = new int[rows][cols];
        int minSteps = Integer.MAX_VALUE;

        while(!queue.isEmpty())
        {
            int[] index = queue.poll();

            int r = index[0];
            int c = index[1];
            int steps = index[2];

            if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1 || visit[r][c] == 1)
                continue;
            
            if(grid[r][c] == 0)
            {
                minSteps = Math.min(minSteps, steps);
                continue;
            }
            
            visit[r][c] = 1;

            steps++;

            for(int[] dir : dirs)
            {
                int newX = dir[0] + r;
                int newY = dir[1] + c;

                queue.offer(new int[]{newX, newY, steps});

            }   
        }


    return minSteps;

    }
}

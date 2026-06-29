class Solution {

    int rows, cols;
    int[][] visited;
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int orangesRotting(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        visited = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(grid[i][j] == 2 )
                {
                    queue.offer(new int[] {i,j,0});
                }
                    
            }
        }

        int minMinutes = bfs(grid, queue);

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return minMinutes;
   
    }

    public int bfs(int[][] grid, Queue<int[]> queue)
    {
        
        int steps = 0;

        while(!queue.isEmpty())
        {
            int[] node = queue.poll();

            int r = node[0];
            int c = node[1];
            steps = node[2];

            visited[r][c] = 1;

            

            
            
            for(int[] dir : dirs)
            {
                int newX = r + dir[0];
                int newY = c + dir[1];

                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1)
                {
                    grid[newX][newY] = 2;

                    queue.offer(new int[]{newX,newY,steps + 1});
                }

            }
        }

        return steps;
    }
}

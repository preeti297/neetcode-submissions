class Solution {
    int rows, cols;
    int[][] visit;
    int[][] dirs = {{0,1}, {1,0}, {0,-1} ,{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        rows = heights.length;
        cols = heights[0].length;

        visit = new int[rows][cols];

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(dfs1(heights,i,j) && dfs2(heights,i,j))
                {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    result.add(coordinates);
                }
            }
        }

        return result;
    }

    public boolean dfs1(int[][] heights, int row, int col)
    {
        boolean isPoss = false;

        if(isPacific(row,col))
        {
            return true;
        }

        visit[row][col] = 1;

        for(int[] dir : dirs)
        {
            int newX = dir[0] + row;
            int newY = dir[1] + col;

            if(newX >=0 && newX < rows && newY >= 0 && newY < cols && heights[row][col] >= heights[newX][newY] && visit[newX][newY] == 0)
            {
                isPoss = isPoss || dfs1(heights,newX,newY);
            }
        }

        visit[row][col] = 0;

        return isPoss;
    }

    public boolean dfs2(int[][] heights, int row, int col)
    {
        boolean isPoss = false;

        if(isAtlantic(row,col))
        {
            return true;
        }

        visit[row][col] = 1;

        for(int[] dir : dirs)
        {
            int newX = dir[0] + row;
            int newY = dir[1] + col;

            if(newX >=0 && newX < rows && newY >= 0 && newY < cols && heights[row][col] >= heights[newX][newY] && visit[newX][newY] == 0)
            {
                isPoss = isPoss || dfs2(heights,newX,newY);
            }
        }

        visit[row][col] = 0;

        return isPoss;
    }

    public boolean isPacific(int row, int col)
    {
        if(row == 0 || col == 0)
            return true;
        return false;
    }

    public boolean isAtlantic(int row, int col)
    {
        if(row == rows - 1 || col == cols - 1)
            return true;
        return false;
    }
}

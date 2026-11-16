class Solution {

    int[] parent;
    int[] rank;

    private int find(int x)
    {
        while(x != parent[x])
            x = parent[x];
        
        return x;
    }

    private boolean union(int x, int y)
    {
        int rx = find(x), ry = find(y);

        if(rx == ry)
            return false;
        
        if(rank[rx] > rank[ry])
        {
            parent[ry] = rx;
            rank[rx]++;
        }
        else
        {
            parent[rx] = ry;
            rank[ry]++;
        }

        return true;
    } 


    public int minCostConnectPoints(int[][] points) {

        /*Krushkals Algorithm - Using Minimum Spanning Tree*/

        int l = points.length;

        parent = new int[l];
        rank = new int[l];

        for(int i = 0 ; i < l ; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        List<int[]> edges = new ArrayList<>();

        for(int i = 0 ; i < l ; i ++)
        {
            for(int j = i+1 ; j < l ; j++)
            {
                int cst = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i,j,cst});
            }
        }

        Collections.sort(edges, new Comparator<int[]>(){

             public int compare(int[] a, int[] b)
            {
                return a[2] - b[2];
            }

    });

        int cost = 0;
        int used = 0;

        for(int[] edge : edges)
        {

            if(union(edge[0],edge[1]))
            {
                cost+=edge[2];
                used++;
                if(used == l-1)
                    break;

            }

        }

        return used == l-1 ? cost : -1;
        
    }
}

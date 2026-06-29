class Solution {
    HashMap<Integer, List<Integer>> graph;
    int[] visited;
    public int countComponents(int n, int[][] edges) {

        graph = new HashMap<>();

        int count = 0;

        visited = new int[n];

        int m = edges.length;

        for(int i = 0 ; i < m ; i++)
        {
            graph.put(edges[i][0], new ArrayList<>());
            graph.put(edges[i][1], new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++)
        {
            //System.out.println(i + ":" + edges[i][0]);
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i = 0 ; i < n ; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i);
                count++;
            }
        }

        return count;

    }

    public void dfs(int node)
    {
        if(graph.containsKey(node))
        {
            visited[node] = 1;
            
            for(int nei : graph.get(node))
            {
                if(visited[nei] == 0)
                {
                    dfs(nei);
                }
            }
        }
    }
}

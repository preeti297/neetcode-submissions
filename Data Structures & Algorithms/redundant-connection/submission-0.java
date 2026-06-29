class Solution {
    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> seen;
    public int[] findRedundantConnection(int[][] edges) {

        graph = new HashMap<>();
        

        int n = edges.length;

        for(int i = 0 ; i < n ; i++)
        {
            graph.put(edges[i][0], new ArrayList<>());
            graph.put(edges[i][1], new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

            seen = new HashSet<>();

            if(!dfs(edges[i][0], -1))
                return edges[i];
        }

        return new int[0];
        
    }

    public boolean dfs(int node, int parent)
    {

        if(seen.contains(node))
        {
            return false;
        }

        seen.add(node);

        boolean isCycle = true;

        for(int nei : graph.get(node))
        {
            if(parent != nei)
            {
                isCycle &= dfs(nei, node);
            }

        }

        return isCycle;

    }
}

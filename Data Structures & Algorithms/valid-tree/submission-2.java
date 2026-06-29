class Solution {

    HashMap<Integer, List<Integer>> graph;
    int count = 0;
    int[] visit;

    public boolean validTree(int n, int[][] edges) {

        if (n == 1 && edges.length == 0)
            return true;

        graph = new HashMap<>();

        HashSet<Integer> seen = new HashSet<>();

        for(int[] edge : edges)
        {
            List<Integer> neighbours = graph.get(edge[0]);


            if(neighbours == null)
            {
                neighbours = new ArrayList<>();
            }
            neighbours.add(edge[1]);

            graph.put(edge[0], neighbours);

            List<Integer> neighbours1 = graph.get(edge[1]);

            if(neighbours1 == null)
            {
                neighbours1 = new ArrayList<>();
            }
            neighbours1.add(edge[0]);

            graph.put(edge[1], neighbours1);
        }

        if(!dfs(0,-1,seen))
            return false;

        return count == n;

    }

    public boolean dfs(int node, int parent, HashSet<Integer> seen)
    {
        if(seen.contains(node))
            return false;

        count++;

        seen.add(node);

        boolean isCycle = true;

        List<Integer> nei = graph.get(node);

        for(int ne : nei)
        { 
            if(parent != ne)
                isCycle &= dfs(ne,node,seen);
        }


        return isCycle;

    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] time : times)
        {
            int u = time[0], v = time[1], dist = time[2];

            List<int[]> pair = new ArrayList<>();

            if(graph.containsKey(u))
                pair = graph.get(u);
            
            pair.add(new int[]{v, dist});

            graph.put(u, pair);
        }

        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[1] - b[1];
            }
        });

        minHeap.offer(new int[]{k, 0});

        int minTime = 0;

        Set<Integer> visited = new HashSet<>();

        while(!minHeap.isEmpty())
        {
            int[] node = minHeap.poll();
            
            if(visited.contains(node[0]))
                continue;
                
            visited.add(node[0]);
            minTime = node[1];

            if(graph.containsKey(node[0]))
            {
                for(int[] nei : graph.get(node[0]))
                {
                    if(visited.contains(nei[0]))
                        continue;
                    
                    minHeap.offer(new int[]{nei[0], nei[1] + minTime});
                }
            }
        }

        return n == visited.size() ? minTime : -1;
        
    }
}
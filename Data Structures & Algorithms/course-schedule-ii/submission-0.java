class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    int[] visited;
    int[] indegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        visited = new int[numCourses];
        indegree = new int[numCourses];

        for(int[] prerequisite : prerequisites)
        {
            List<Integer> neighbours;

            if(graph.containsKey(prerequisite[1]))
            {
                neighbours = graph.get(prerequisite[1]);
            }
            else
            {
                neighbours = new ArrayList<>();
            }

            neighbours.add(prerequisite[0]);

            graph.put(prerequisite[1], neighbours);

            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++)
        {
            if(indegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        List<Integer> courses = bfs(queue, numCourses);

        int[] result = new int[courses.size()];
        int i = 0;

        for(int course : courses)
        {
            result[i] = course;
            i++;
        }

        return result; 
    }

    public List<Integer> bfs(Queue<Integer> queue, int numCourses)
    {
        int count = 0;

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty())
        {
            int node = queue.poll();

            visited[node] = 1;

            result.add(node);
            
            count++;

            List<Integer> neighbours = graph.get(node) == null ? new ArrayList<>() : graph.get(node);

            for(int nei : neighbours)
            {

                if(visited[nei] == 0)
                {
                    indegree[nei]--;
                    if(indegree[nei] == 0)
                    {
                        queue.offer(nei);
                    }
                }

            }
        }

        if(count == numCourses)
            return result;
        else
            return new ArrayList<>();
    }
}

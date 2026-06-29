class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        indegree = new int[numCourses];

        visited = new int[numCourses];

        for(int[] prerequisite : prerequisites)
        {
            List<Integer> subjects;
            if(graph.containsKey(prerequisite[1]))
            {
                subjects = graph.get(prerequisite[1]);
            }
            else
            {
                subjects = new ArrayList<>();
            }

            subjects.add(prerequisite[0]);
            graph.put(prerequisite[1], subjects);

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

        return bfs(queue, numCourses);
        
    }

    public boolean bfs(Queue<Integer> queue, int numCourses)
    {
        int count = 0;

        while(!queue.isEmpty())
        {
            int node = queue.poll();

            count++;

            visited[node] = 1;

            List<Integer> subjects = graph.get(node) == null ? new ArrayList<>() : graph.get(node);

            for(int subject : subjects)
            {
                if(visited[subject] == 0)
                {
                    indegree[subject]--;

                    if(indegree[subject] == 0)
                    {
                        queue.offer(subject);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

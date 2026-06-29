class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char ch : tasks)
        {
            freq[ch - 'A']++;
        }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for(int i = 0 ; i < 26 ; i++)
    {
        if(freq[i] > 0)
            pq.offer(freq[i]);
    }

    Queue<int[]> queue = new LinkedList<>();

    int time = 0;

    while(!pq.isEmpty() || !queue.isEmpty())
    {
        time++;

        if(pq.isEmpty())
        {
            time = queue.peek()[1];
        }else
        {
            int cnt = pq.poll() - 1;
            if(cnt > 0)
                queue.offer(new int[]{cnt, time + n});
        }

        if(!queue.isEmpty() && queue.peek()[1] == time)
        {
            pq.offer(queue.poll()[0]);
        }


    }

    return time;
        
    }
}

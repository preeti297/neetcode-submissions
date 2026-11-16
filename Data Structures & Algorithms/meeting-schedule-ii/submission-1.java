/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.size() == 0)
            return 0;

        Collections.sort(intervals, (a,b) -> a.start - b.start);

        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b)
            {
                return a.compareTo(b);
            }
        });

        heap.add(intervals.get(0).end);

        for(int i =1 ; i< intervals.size() ; i++)
        {
            if(heap.peek() <= intervals.get(i).start)
            {
                heap.poll();
            }
            heap.offer(intervals.get(i).end);
        }

        return heap.size();

    }
}

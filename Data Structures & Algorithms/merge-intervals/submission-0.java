class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        LinkedList<int[]> result = new LinkedList<>();

        int l = intervals.length;

        for(int i = 0 ; i < l ; i++)
        {
            if(result.isEmpty() || result.getLast()[1] < intervals[i][0])
            {
                result.add(intervals[i]);
            }
            else
            {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
        
    }
}

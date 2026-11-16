class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        /*Sort based on end times as we can do mximum events that end quickly, find non overlapping intervals and then calculate total length minus non overlapping intervals*/

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int count = 1 ;

        int endTime = intervals[0][1];

        for(int i = 1 ; i < intervals.length ; i++)
        {
            if(endTime <= intervals[i][0])
            {
                endTime = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;




        
    }
}

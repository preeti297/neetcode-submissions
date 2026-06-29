class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> kClosestPoints = new PriorityQueue<>(new Comparator<int[]>(){

            public int compare(int[] a , int[] b)
            {
                return ((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
            }

        });

        for(int[] point : points)
        {
            kClosestPoints.offer(point);
        }

        int[][] ans = new int[k][2];

        int i = 0;
        while(i < k)
        {
            int[] point = kClosestPoints.poll();
            ans[i][0] = point[0];
            ans[i][1] = point[1];
            i++;
        }

        return ans;
        

    }
}

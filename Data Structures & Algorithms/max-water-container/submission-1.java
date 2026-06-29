class Solution {
    public int maxArea(int[] heights) {

        int l = heights.length;

        int i = 0, j = l - 1;

        int mxArea = 0;

        while(i < j)
        {

            int area = (j-i) * Math.min(heights[i], heights[j]);

            mxArea = Math.max(mxArea, area);

            if(heights[i] < heights[j])
                i++;
            else
                j--;

        }

        return mxArea;
        
    }
}

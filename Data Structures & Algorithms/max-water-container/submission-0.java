class Solution {
    public int maxArea(int[] heights) {

        int len = heights.length;
        int i = 0;
        int j = len - 1;
        int maxArea = 0;

        while(i < j)
        {
            maxArea = Math.max(maxArea, (j-i) * Math.min(heights[i], heights[j]));

            if(heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return maxArea;
        
    }
}

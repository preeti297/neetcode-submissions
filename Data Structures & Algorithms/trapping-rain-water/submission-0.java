class Solution {
    public int trap(int[] height) {

        int len = height.length;
        int[] mxR = new int[len];
        int[] mxL = new int[len];

        mxL[0] = height[0];
        mxR[len - 1] = height[len-1];

        for(int i = 1 ; i < len ; i++)
        {
            mxL[i] = Math.max(height[i], mxL[i-1]);

        }

        for(int j = len - 2 ; j >= 0 ;j--)
        {
            mxR[j] = Math.max(height[j], mxR[j+1]);
        }

        int ans = 0;

        for(int i  = 0 ; i < len ; i++)
        {
            ans += Math.min(mxR[i], mxL[i]) - height[i];
        }

        return ans;
        
    }
}

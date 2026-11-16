class Solution {
    public int maxProduct(int[] nums) {

        /*Kadane's Algorithm - since two negative can give positive, keep a track of min product and max product locally, later caluclate global */
        /*Another approach calculate prefix and suffix and then maximum of perfix and suffix*/

        int minProd = nums[0], maxProd = nums[0], l = nums.length;

        int mx = nums[0];

        for(int i = 1 ; i < l ; i ++)
        {
            int x = nums[i];

            int a = x*minProd;

            int b = x*maxProd;


            maxProd = Math.max(x, Math.max(a,b));
            minProd = Math.min(x, Math.min(a,b));
            

            mx = Math.max(mx, maxProd);


        }

        return mx;
        
    }
}

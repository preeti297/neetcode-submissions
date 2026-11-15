class Solution {
    public int[] countBits(int n) {

        if(n == 0)
            return new int[]{0};

        int[] output = new int[n+1];

        for(int i = 1 ; i <= n ; i++)
        {
            output[i] = output[i >> 1] + (i & 1);

        }

        return output;
        
    }
}

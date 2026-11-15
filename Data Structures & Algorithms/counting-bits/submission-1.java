class Solution {
    public int[] countBits(int n) {

        if(n == 0)
            return new int[]{0};

        int[] output = new int[n+1];

        output[0] = 0;
        output[1] = 1;

        int offset = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            if(offset * 2 == i)
                offset = i;
            output[i] = 1 + output[i-offset];

        }

        return output;
        
    }
}

class Solution {
    public int[] countBits(int n) {

        if(n == 0)
            return new int[]{0};

        int[] output = new int[n+1];

        for(int i = 1 ; i <= n ; i++)
        {
            output[i] = output[i >> 1] + (i & 1);
            //output[i>>1] will give number of 1's after last digit is rmeoved
            // i & 1 - will tell the last digit - if one gets added, if 0 doesnt get added
            //13 - 1101 - 110 - 6 we already know number of 1's so 2 + last digit is 1  - 2 + 1 - 3

        }

        return output;
        
    }
}

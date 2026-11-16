class Solution {
    public String multiply(String num1, String num2) {

        /*
        do school grade multiplication - nums2 will always be smaller and nums 1, bigger, multiply - create rows and then add but in optimized solution the ith and jth element will be stored in i+j+1 and also padding not required because i reduces and so the position to store in is also reduced 
        */

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length(), n = num2.length();

        int[] result = new int[m+n];

        for(int i = m-1 ; i>=0 ;i--)
        {
            for(int j = n-1; j>=0 ; j--)
            {
                char ch1 = num1.charAt(i);
                char ch2 = num2.charAt(j);

                int mul = (ch1 -'0') * (ch2 - '0');

                mul += result[i+j+1];
                result[i+j+1] = mul%10;
                result[i+j] += mul/10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num : result)
        {
            if(!(sb.length() == 0 && num == 0))
            {
                sb.append(num);
            }
        }

        return sb.toString();
        
    }
}

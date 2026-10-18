class Solution {
    public String longestPalindrome(String s) {

        int mxL = 0, mxR = 0, mxLength = 0;

        int strL = s.length();
        String reversed = new StringBuilder(s).reverse().toString();

        if(s.equals(reversed))
            return s;

        for(int i = 0 ; i < strL ; i++)
        {
            int left = i, right = i;

            while(left >= 0 && right < strL && s.charAt(left) == s.charAt(right))
            {
                if(mxLength < (right-left+1))
                {
                mxL = left;
                mxR = right;
                mxLength = right-left+1;
                }
                left--;
                right++;
            }

            left = i; right = i+1;

             while(left >= 0 && right < strL && s.charAt(left) == s.charAt(right))
            {
                if(mxLength < (right-left+1))
                {
                mxL = left;
                mxR = right;
                mxLength = right-left+1;
                }
                left--;
                right++;
            }
        }

        StringBuilder str = new StringBuilder();

        for(int i = mxL ; i <= mxR ; i++)
        {
            str.append(s.charAt(i));
        }

        return str.toString();
        
    }
}

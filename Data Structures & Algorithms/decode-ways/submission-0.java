class Solution {
    public int numDecodings(String s) {

        int l = s.length();
        int[] memo = new int[l];
        return helper(s,0,memo);
        
    }

    public int helper(String s, int index, int[] memo)
    {

        if(index == s.length())
        {
            return 1;
        }

        if(s.charAt(index) == '0')
            return 0;

        if(memo[index] != 0)
            return memo[index];

        

        
        
        int ways = 0;

        ways += helper(s,index+1, memo);

        if(index < s.length() - 1)
        {
        int num = (s.charAt(index) - '0') * 10 + (s.charAt(index+1) - '0');
        if(num <= 26)
            ways += helper(s, index+2, memo);
        }

        memo[index] =  ways;

        return memo[index];

    }
}

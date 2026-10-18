class Solution {
    public int countSubstrings(String s) {

        int count = 0;

        int strL = s.length();

        for(int i = 0 ; i < strL ; i++)
        {
            int left = i, right = i;

            while(left >= 0 && right < strL && s.charAt(left) == s.charAt(right))
            {
                count++;
                left--;
                right++;
            }

            left = i; right = i+1;

             while(left >= 0 && right < strL && s.charAt(left) == s.charAt(right))
            {
                count++;
                left--;
                right++;
            }
        }

       

        return count;
        
    }
}

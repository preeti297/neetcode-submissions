class Solution {
    public int characterReplacement(String s, int k) {

        //Intuition - Replace the characters other than maximum frwuency with maximum frequency character - that can be found by length of substring - maximum frequency if <=k then calculate the maximum.

        HashMap<Character, Integer> seen = new HashMap<>();

        int left = 0;
        int mxFreq = 0;
        int mxLen = 0;
        int len = s.length();

        for(int right = 0 ; right < len ; right++)
        {
            char ch = s.charAt(right);
            seen.put(ch, seen.getOrDefault(ch,0)+1);
            mxFreq = Math.max(mxFreq, seen.get(ch));

            if(right - left + 1 - mxFreq > k)
            {
                char c = s.charAt(left);
                seen.put(c, seen.get(c) - 1);
                left++;
                
            }

            mxLen = Math.max(mxLen, right - left + 1);

        }

        

        return mxLen;

        
    }
}

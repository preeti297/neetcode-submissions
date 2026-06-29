class Solution {
    public int lengthOfLongestSubstring(String s) {

        int ln = s.length();

        int i = 0;

        int mxLength = 0;

        HashMap<Character, Integer> seen = new HashMap<>();

        for(int j = 0 ; j < ln ; )
        {
            if(i < j && seen.containsKey(s.charAt(j)))
            {
                if(seen.get(s.charAt(j)) >= i)
                    i = seen.get(s.charAt(j)) + 1;  
                
            }
            mxLength = Math.max(mxLength, j-i+1); 
            seen.put(s.charAt(j), j);
            j++;
            

        }

        return mxLength;
        
    }
}

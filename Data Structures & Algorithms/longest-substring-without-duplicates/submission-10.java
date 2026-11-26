class Solution {
    //Intuition - the window condition breaks, when a character is seen again, update the left pointer
    public int lengthOfLongestSubstring(String s) {

        int ln = s.length();

        int left = 0;

        int mxLength = 0;

        HashMap<Character, Integer> seen = new HashMap<>();

        for(int right = 0 ; right < ln ; right++)
        {
            if(seen.containsKey(s.charAt(right)))
            {
                if(seen.get(s.charAt(right)) >= left)//this condiiton checks so that left doesnt go backward again
                    left = seen.get(s.charAt(right)) + 1;  
                
            }
            mxLength = Math.max(mxLength, right-left+1); 
            seen.put(s.charAt(right), right);
            

        }

        return mxLength;
        
    }
}

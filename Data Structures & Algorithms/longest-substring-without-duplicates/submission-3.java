class Solution {
    public int lengthOfLongestSubstring(String s) {

        int mxLength = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int len = s.length();

        for(int right = 0 ; right < len ; right++)
        {
            char ch = s.charAt(right);
            if(left < right && seen.containsKey(ch))
            {
                if(seen.get(ch) >= left)
                    left = seen.get(ch) + 1;
            }
            mxLength = Math.max(mxLength, right-left+1);
            System.out.println(left + ":" + right);
            System.out.println(mxLength);
            seen.put(ch, right);
            
            

        }

        return mxLength;
        
    }
}

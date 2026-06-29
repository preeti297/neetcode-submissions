class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> s1Chars = new HashMap<>();

        int s1Len = s1.length();
        int s2Len = s2.length();

        for(char ch : s1.toCharArray())
        {
            s1Chars.put(ch, s1Chars.getOrDefault(ch,0)+1);
        }

        int right = 0, left = 0;

        HashMap<Character, Integer> s2Chars = new HashMap<>();

        for(; right < s1Len ; right++)
        {
            char ch = s2.charAt(right);
            s2Chars.put(ch, s2Chars.getOrDefault(ch,0) + 1);
        }

        if(checkHashMap(s1Chars, s2Chars))
            return true;
        
        for(; right < s2Len ; right++)
        {
            int index = right - s1Len;
            char ch = s2.charAt(index);

            s2Chars.put(ch, s2Chars.get(ch)-1);

            char c = s2.charAt(right);
            s2Chars.put(c, s2Chars.getOrDefault(c,0) + 1);

            System.out.println(s2Chars);

            if(checkHashMap(s1Chars, s2Chars))
                return true;
        }

        return false;

        
    }

    public boolean checkHashMap(HashMap<Character, Integer> s1Chars, HashMap<Character, Integer> s2Chars)
    {
        for(char ch : s1Chars.keySet())
        {
            if(!s2Chars.containsKey(ch))
                return false;
            else
            {
                if(s2Chars.get(ch) < s1Chars.get(ch))
                    return false;
            }
        }

        return true;
    }
}

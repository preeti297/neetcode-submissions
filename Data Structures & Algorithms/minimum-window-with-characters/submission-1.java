class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length())
            return "";

        int right = 0, left = 0;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        int sLen = s.length();
        int tLen = t.length();

        String result;

        int minLen = Integer.MAX_VALUE;
        int minL = -1;
        int minR = -1;

        for(char ch : t.toCharArray())
            tMap.put(ch, tMap.getOrDefault(ch,0) + 1);
        

        for( ; right < sLen ; right++)
        {
            char ch = s.charAt(right);

            sMap.put(ch, sMap.getOrDefault(ch,0) + 1);

            while(checkMaps(sMap, tMap))
            {
                    if(minLen > right - left + 1)
                    {   
                        minLen = right - left + 1;
                        minL = left;
                        minR = right;

                    }
                    char c = s.charAt(left);
                    sMap.put(c, sMap.get(c) - 1);
                    left++;
                    
            }
        }

        return minL == -1 ? "" : s.substring(minL, minR + 1);
            
    }


    public boolean checkMaps(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap)
    {
        for(char ch : tMap.keySet())
        {
            if(!sMap.containsKey(ch))
                return false;
            else
            {
                if(sMap.get(ch) < tMap.get(ch))
                    return false;
            }
        }

        return true;
    }
}

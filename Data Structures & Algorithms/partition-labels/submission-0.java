class Solution {
    public List<Integer> partitionLabels(String s) {

        /*
        Intuition - keep the last indexes in hashmap now iterate through the string and keep updating the end, if index = =end, then thats one partition and increment the left index;
        */

        Map<Character, Integer> lastIndex = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++)
        {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();

        int right =0, left = 0;

        for(int i = 0 ; i < s.length() ; i++)
        {
            right = Math.max(right, lastIndex.get(s.charAt(i)));

            if(i == right)
            {
                result.add(right-left+1);
                left = right + 1;
            }
        }

        return result;
        
    }
}

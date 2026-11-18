class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        /*
        Loop through the wordDict and check if every word is present from start to end, if yes return true, if not false, but this would lead to exponential time complexity so store if index actually has a word
        */
        Boolean[] memo = new Boolean[s.length()];

        return canBreak(0,s,wordDict, memo);
        
    }

    public boolean canBreak(int index, String s, List<String> wordDict, Boolean[] memo)
    {
        if(index == s.length())
        {
            return true;
        }

        if(memo[index] != null)
            return memo[index];

        for(String word : wordDict)
        {
            if(s.startsWith(word, index) && canBreak(index + word.length(),s, wordDict, memo))
            {
                memo[index] = true;
                return memo[index];
            }


        }

        memo[index] = false;

        return memo[index];
    }
}

class Solution {
    public int minDistance(String word1, String word2) {

        Integer[][] memo = new Integer[word1.length()+1][word2.length()+1];

        return dfs(0,0, word1, word2,memo);
        
    }

    private int dfs(int index1, int index2, String word1, String word2, Integer[][] memo)
    {
        if(index1 == word1.length())
            return word2.length() - index2;
        
        if(index2 == word2.length())
            return word1.length() - index1;
        
        if(memo[index1][index2] != null)
            return memo[index1][index2];

        
        if(word1.charAt(index1) == word2.charAt(index2))
            return dfs(index1+1, index2+1, word1, word2, memo);


        
        int edits  = 1 + Math.min(dfs(index1+1, index2+1, word1, word2, memo), Math.min(dfs(index1, index2+1, word1, word2, memo), dfs(index1+1, index2, word1, word2, memo)));

        memo[index1][index2] = edits;

        return memo[index1][index2];
    }
}

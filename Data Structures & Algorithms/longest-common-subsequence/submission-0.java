class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int l1 = text1.length();
        int l2 = text2.length();
        int[][] memo = new int[l1][l2];

        for(int i = 0 ; i < l1 ; i++)
        {
            for(int j = 0 ; j < l2 ; j++)
            {
                memo[i][j] = -1;
            }
        }

        return dfs(0,0,text1,text2,memo);  
    }

    private int dfs(int i, int j , String text1, String text2, int[][] memo)
    {
        if(i ==  text1.length() || j == text2.length())
            return 0;
        
        if(memo[i][j] != -1)
            return memo[i][j];

        int res = 0;

        if(text1.charAt(i) == text2.charAt(j))
        {
            res = 1 + dfs(i+1,j+1 ,text1 , text2, memo);
        }
        else
           res = Math.max(dfs(i,j+1,text1,text2, memo), dfs(i+1,j,text1,text2, memo));

           memo[i][j] = res;

           return memo[i][j];
    }
}

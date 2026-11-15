class Solution {
    List<String> result;
    int m;
    public List<String> generateParenthesis(int n) {

        result = new ArrayList<>();

        m = n;

        StringBuilder temp = new StringBuilder();
        backtracking(temp, 0, 0);

        return result;
        
    }

    private void backtracking(StringBuilder temp, int open, int close)
    {
        System.out.println(open + ":" + close);
        if(temp.length() == 2 * m)
        {
            result.add(temp.toString());
            return;
        }

        if(open < m)
        {
            temp.append('(');
            backtracking(temp, open + 1, close);
            temp.deleteCharAt(temp.length()-1);
        }

        if(close < open)
        {
            temp.append(')');
            backtracking(temp, open, close + 1);
            temp.deleteCharAt(temp.length()-1);

        }
    }
}

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtracking(result,path,0,s);

        return result;
        
    }

    private void backtracking(List<List<String>> result, List<String> path, int start, String s)
    {
        if(start == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start ; i < s.length() ; i++)
        {
            if(isPalindrome(s, start, i))
            {
                path.add(s.substring(start,i+1));
                backtracking(result, path, i+1, s);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r)
    {
        while(l <= r)
        {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}

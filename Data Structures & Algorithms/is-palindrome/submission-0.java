class Solution {
    public boolean isPalindrome(String s) {

        int len = s.length();
        int i = 0;
        int j = len - 1;
        
        while(i < j)
        {
            if(!Character.isLetterOrDigit(s.charAt(i)))
                i++;
            if(!Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(Character.isLetterOrDigit(s.charAt(i)) &&  Character.isLetterOrDigit(s.charAt(j)))
            {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
                else
                {
                    i++;
                    j--;
                }
            }
        }

        return true;
        
    }
}

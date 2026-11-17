class Solution {
    public boolean checkValidString(String s) {

        /*
        Intuition -valid parenthesis - use stack since * can be also used as open or closed, lets have two stack one with '(' and another with '*' if ')' is encountered we pop from open stack if not star and if stars and open still remain then* will be used as ')'
        */

        Stack<Integer> open  =  new Stack<>();
        Stack<Integer> star  =  new Stack<>();

        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
                open.push(i);
            else if(ch == '*')
                star.push(i);
            else
            {
                if(!open.isEmpty())
                    open.pop();
                else if(!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }

        while(!open.isEmpty() && !star.isEmpty())
        {
            if(open.pop() > star.pop())
                return false;
        }

        return open.isEmpty();

        
    }
}

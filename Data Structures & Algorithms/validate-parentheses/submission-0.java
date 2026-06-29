class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(ch =='(' || ch =='{' || ch =='[')
            {
                stack.add(ch);
            }
            else
            {
                if(!stack.isEmpty() && stack.peek() == map.get(ch))
                {
                    stack.pop();
                }
                else
                    return false;
            }
        }

        return stack.isEmpty() ? true : false;
        
    }
}

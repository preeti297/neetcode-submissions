class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(String token : tokens)
        {
            if(operators.contains(token))
            {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                if(token.charAt(0) == '+')
                {
                    stack.push(operand1 + operand2);
                }
                else if(token.charAt(0) == '-')
                {
                    stack.push(operand1 - operand2);
                }
                else if(token.charAt(0) == '*')
                {
                    stack.push(operand1 * operand2);
                }
                else if(token.charAt(0) == '/')
                {
                    stack.push(operand1 / operand2);
                }
            }
            else
            {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
        
    }
}

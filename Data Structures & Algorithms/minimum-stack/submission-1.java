class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {

        stack.push(val);

        if(minStack.isEmpty())
        {
            minStack.push(val);
        }
        else
        {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }
    
    public void pop() {

        if(stack.isEmpty())
            return;
        int top = stack.pop();

        if(top == minStack.peek());
        {
            minStack.pop();
        }
    }
    
    public int top() {

        if(!stack.isEmpty())
        {
            return stack.peek();
        }
    
    return -1;
        
    }
    
    public int getMin() {

        if(!minStack.isEmpty())
        {
            return minStack.peek();
        }
    
    return -1;
        
    }
}

class MinStack {

    Stack<int[]> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {

        if(minStack.isEmpty())
        {
            minStack.push(new int[]{val, val});
        }
        else
        {
            minStack.push(new int[]{val, Math.min(minStack.peek()[1], val)});
        }
    }
    
    public void pop() {

        if(minStack.isEmpty())
            return;

        minStack.pop();
        
    }
    
    public int top() {

        if(!minStack.isEmpty())
        {
            return minStack.peek()[0];
        }
    
    return -1;
        
    }
    
    public int getMin() {

        if(!minStack.isEmpty())
        {
            return minStack.peek()[1];
        }
    
    return -1;
        
    }
}

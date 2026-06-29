class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int ln = temperatures.length;

        int[] result = new int[ln];

        stack.push(0);

        for(int i = 1 ; i < ln ; i++)
        {

            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
            {
                int index = stack.pop();

                result[index] = i - index;

            }

                stack.push(i);
        }

        while(!stack.isEmpty())
        {
            int index = stack.pop();

            result[index] = 0;
        }

        return result;
        
    }
}

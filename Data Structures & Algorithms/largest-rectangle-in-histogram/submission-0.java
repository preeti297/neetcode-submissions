class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        int l = heights.length;

        for(int i = 0 ; i < l ; i++)
        {
            int start = i;

            while(!stack.isEmpty() && stack.peek().getValue() > heights[i])
            {
                Pair<Integer, Integer> height = stack.pop();
                maxArea = Math.max(maxArea, height.getValue() * (i - height.getKey()));
                start = height.getKey();
            }

            stack.push(new Pair<>(start, heights[i]));

            //System.out.println(maxArea);
        }

        while(!stack.isEmpty())
        {
            Pair<Integer, Integer> height = stack.pop();
            maxArea = Math.max(maxArea, height.getValue() * (l - height.getKey()));

        }

        return maxArea;
        
    }
}

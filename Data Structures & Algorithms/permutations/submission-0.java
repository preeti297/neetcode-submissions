class Solution {
    List<List<Integer>> answers = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
    
    this.nums = nums;


    List<Integer> permutes = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    backtrack(0, permutes, visited);


    return answers;
        
    }

    public void backtrack(int start, List<Integer> permutes, Set<Integer> visited)
    {

        if(permutes.size() == nums.length)
        {
            answers.add(new ArrayList<>(permutes));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(!visited.contains(i))
            {
                permutes.add(nums[i]);
                visited.add(i);
                backtrack(i, permutes, visited);
                permutes.remove(permutes.size()-1); 
                visited.remove(i);  

            }
        }
    }
}

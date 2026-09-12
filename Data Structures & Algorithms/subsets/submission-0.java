class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtracking(0,nums,temp);

        return result;
        
    }

    public void backtracking(int index, int[] nums, List<Integer> temp)
    {

        
        result.add(List.copyOf(temp));

        for(int i = index ; i < nums.length ; i++)
        {
            temp.add(nums[i]);
            backtracking(i+1, nums, temp);
            temp.remove(temp.size() - 1);
        }

    }
}

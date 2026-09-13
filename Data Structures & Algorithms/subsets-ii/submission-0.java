class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        result = new ArrayList<>();

        Arrays.sort(nums);

        backtracking(0, nums, new ArrayList<>());

        return result;
        
    }

    public void backtracking(int index, int[] nums, List<Integer> temp)
    {
        System.out.println(temp);
        result.add(List.copyOf(temp));

        for(int j =  index ; j < nums.length ; j++)
        {
            if(j > index && nums[j] == nums[j-1])
            {
                continue;
            }
            temp.add(nums[j]);
            backtracking(j+1, nums, temp);
            temp.remove(temp.size()-1);
        }
    }
}

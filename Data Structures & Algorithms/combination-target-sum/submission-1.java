class Solution {
    List<List<Integer>> answers = new ArrayList<>();
    int target;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] nums, int target) {

      this.candidates = nums;

      this.target = target;

        List<Integer> res = new ArrayList<>();

        backtrack(res, 0, 0);

        return answers;  
    }

     public void backtrack(List<Integer> res, int start, int sum)
    {

        if(sum == this.target)
        {
            this.answers.add(new ArrayList<>(res));
            return;
        }

        if(sum > target)
            return;
        
        for(int i = start ; i < this.candidates.length ; i++)
        {
            res.add(this.candidates[i]);
            backtrack(res, i, sum + this.candidates[i]);
            res.remove(res.size() - 1);
        }

    }
}

class Solution {
    public boolean canJump(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();

        return recursion(nums, 0, seen);
        
    }

    private boolean recursion(int[] nums, int pos, HashSet<Integer> seen)
    {
        boolean res = false;

        if(seen.contains(pos))
            return false;

        if(pos >= nums.length - 1)
            return true;

        seen.add(pos);

        for(int p = 1 ; p <= nums[pos] ; p++)
        {

        res = res || recursion(nums, pos + p, seen);
        }

        return  res;
    }
}

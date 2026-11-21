class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = 1;

        for(int i = 1 ; i < n ; i++)
        {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        int rightProduct = 1;

        for(int i = n-1 ; i >= 0 ; i--)
        {
            leftProduct[i] = leftProduct[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return leftProduct;
        
    }
}  
